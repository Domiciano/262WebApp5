package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Professor;

import java.util.List;

public interface ProfessorService {

    void renameProfessor(Integer id, String name);

    void save(Professor professor);

    List<Professor> getAll();
}
