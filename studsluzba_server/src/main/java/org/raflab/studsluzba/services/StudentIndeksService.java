package org.raflab.studsluzba.services;

import org.raflab.studsluzba.repositories.StudentIndeksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class StudentIndeksService {
    
    @Autowired
    private StudentIndeksRepository studentIndeksRepository;

    @Transactional(readOnly = true)
    public int findBroj(int godina, String studProgramOznaka) {
        List<Integer> brojeviList = studentIndeksRepository.
                findBrojeviByGodinaAndStudProgramOznaka(godina, studProgramOznaka);

        return findNextAvailableNumber(brojeviList);
    }

    private int findNextAvailableNumber(List<Integer> brojeviList) {
        Collections.sort(brojeviList);

        int expected = 1;
        for (int num : brojeviList) {
            if (num != expected) {
                return expected; // Found a gap
            }
            expected++;
        }

        return expected; // No gap
    }
}
