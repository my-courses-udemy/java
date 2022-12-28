package org.bo.mockito.examples.repository;

import org.bo.mockito.examples.models.Exam;

import java.util.List;

public interface RepositoryExam {
  Exam store(Exam exam);
  List<Exam> findAll();
}
