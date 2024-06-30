package com.debarshi.learnscape.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        if(Objects.isNull(SecurityContextHolder.getContext().getAuthentication()))
        {
            return Optional.empty();
        }
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}