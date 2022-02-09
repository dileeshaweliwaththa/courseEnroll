package com.uwu.courseenroll.Undergrads;

import com.uwu.courseenroll.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UndergradService {

    @Autowired
    UndergradRepo undergradRepo;

    public List<Undergrad> getUndergrads() {
        return undergradRepo.findAll();
    }

    public void saveUndergrad(Undergrad undergrad) {
        undergradRepo.save(undergrad);
    }

    public Undergrad getById(Long undId) throws UserNotFoundException {
        Optional<Undergrad> result = undergradRepo.findById(undId);
        if (result.isPresent()){
            return result.get();

        }
        throw new UserNotFoundException("No Users Exists with the Emp ID" + undId);
    }

    public void deleteByEmpId(Long undId) {
        undergradRepo.deleteById(undId);
    }
}
