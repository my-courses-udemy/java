package org.bo.mockito.examples.repository;

import org.bo.mockito.examples.models.Exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RepositoryExamImpl implements RepositoryExam {
  @Override
  public Exam store(Exam exam) {
    return exam;
  }

  @Override
  public List<Exam> findAll() {
    return Collections.emptyList();
  }
}
