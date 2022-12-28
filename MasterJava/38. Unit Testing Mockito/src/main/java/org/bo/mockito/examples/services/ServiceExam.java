package org.bo.mockito.examples.services;

import org.bo.mockito.examples.models.Exam;

public interface ServiceExam {
  Exam findByName(String name);
  Exam findExamByQuestionsName(String name);
  Exam store(Exam exam);
}
