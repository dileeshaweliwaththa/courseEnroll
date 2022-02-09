package com.uwu.courseenroll.Lectures;

import com.uwu.courseenroll.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService {

    @Autowired
    LectureRepo lectureRepo;

    public List<Lecture> getLectures() {
        return lectureRepo.findAll();
    }

    public void saveLecture(Lecture lecture) {
        lectureRepo.save(lecture);
    }

    public Lecture getById(Long undId) throws UserNotFoundException {
        Optional<Lecture> result = lectureRepo.findById(undId);
        if (result.isPresent()){
            return result.get();

        }
        throw new UserNotFoundException("No Users Exists with the Emp ID" + undId);
    }

    public void deleteByEmpId(Long undId) {
        lectureRepo.deleteById(undId);
    }


}
