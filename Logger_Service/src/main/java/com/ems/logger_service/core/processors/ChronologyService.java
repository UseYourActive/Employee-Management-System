package com.ems.logger_service.core.processors;

import com.ems.logger_service.persistence.entities.Chronology;
import com.ems.logger_service.persistence.entities.ChronologyFilter;
import com.ems.logger_service.persistence.entities.IndexVM;
import com.ems.logger_service.persistence.entities.MessageLog;
import com.ems.logger_service.persistence.enums.Type;
import com.ems.logger_service.persistence.repositories.ChronologyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChronologyService {
    private final ChronologyRepository chronologyRepository;

    public void saveChronology(Chronology chronology) {
        chronologyRepository.save(chronology);
    }

    public IndexVM<MessageLog> gerChronology(ChronologyFilter filter) {
        Page<Chronology> page = chronologyRepository.findChronologyByFilter(filter.email(), filter.createdAfter(), filter.createdBefore(),
                filter.type() == null ? "" : filter.type().getLabel(), PageRequest.of(filter.page(), filter.pageSize()));

        return new IndexVM<>(page.map(MessageLog::new));
    }

    public Set<String> getTypes() {
        return Arrays.stream(Type.values())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }
}
