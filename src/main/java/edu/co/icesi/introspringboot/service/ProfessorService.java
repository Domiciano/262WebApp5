package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Professor;

public interface ProfessorService {

    void renameProfessor(Integer id, String name);

    void save(Professor professor);
}
