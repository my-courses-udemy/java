package org.bo.mockito.examples.services;

import org.bo.mockito.examples.models.Exam;

import java.util.Arrays;
import java.util.List;

public class Data {
  public static final List<Exam> EXAMS = Arrays.asList(new Exam(1L, "math"),
          new Exam(2L, "Physics"),
          new Exam(3L, "Language"));

  public static final List<String> QUESTIONS = Arrays.asList("Arithmetic", "Calculus", "Programming");
  public static final Exam EXAM = new Exam(null, "Math");
}
