package com.debarshi.learnscape.service;

import com.debarshi.learnscape.config.LearnscapeProps;
import com.debarshi.learnscape.constants.LearnscapeConstants;
import com.debarshi.learnscape.model.Contact;
import com.debarshi.learnscape.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    LearnscapeProps learnscapeProps;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(LearnscapeConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if(!Objects.isNull(savedContact) && savedContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){
        int pageSize = learnscapeProps.getPageSize();
        if(null!= learnscapeProps.getContact() && null!= learnscapeProps.getContact().get("pageSize")){
            pageSize = Integer.parseInt(learnscapeProps.getContact().get("pageSize").trim());
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatusWithQuery(
                LearnscapeConstants.OPEN,pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        int rows = contactRepository.updateMsgStatusNative(LearnscapeConstants.CLOSE,contactId);
        if(rows > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }

}
