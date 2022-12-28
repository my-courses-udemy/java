package org.bo.mockito.examples.services;

import org.bo.mockito.examples.models.Exam;
import org.bo.mockito.examples.repository.RepositoryExam;
import org.bo.mockito.examples.repository.RepositoryQuestion;

import java.util.List;

public class ServiceExamImpl implements ServiceExam {
  private RepositoryExam repositoryExam;
  private RepositoryQuestion repositoryQuestion;

  public ServiceExamImpl(RepositoryExam repositoryExam, RepositoryQuestion repositoryQuestion) {
    this.repositoryExam = repositoryExam;
    this.repositoryQuestion = repositoryQuestion;
  }

  @Override
  public Exam findByName(String name) {
    var optionalTest = repositoryExam.findAll()
            .stream().filter(element -> element.getName().equals(name))
            .findFirst();
    return optionalTest.orElseThrow();
  }

  @Override
  public Exam findExamByQuestionsName(String name) {
    Exam exam = findByName(name);
    List<String> questions = repositoryQuestion.findQuestionsByExamId(exam.getId());
    exam.setQuestions(questions);
    return exam;
  }

  @Override
  public Exam store(Exam exam) {
    if (!exam.getQuestions().isEmpty()) {
      repositoryQuestion.storeList(exam.getQuestions());
    }
    return repositoryExam.store(exam);
  }
}
