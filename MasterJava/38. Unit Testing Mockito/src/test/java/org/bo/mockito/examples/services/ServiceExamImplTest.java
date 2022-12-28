package org.bo.mockito.examples.services;

import org.bo.mockito.examples.models.Exam;
import org.bo.mockito.examples.repository.RepositoryExam;
import org.bo.mockito.examples.repository.RepositoryQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceExamImplTest {

  @Mock
  private RepositoryExam repository;
  @Mock
  private RepositoryQuestion repositoryQuestion;
  @InjectMocks
  private ServiceExamImpl service; // it is necessary when is used annotation not to use interfaces

  @BeforeEach
  void setUp() {
    // one way to activate annotations
//    MockitoAnnotations.openMocks(this);

//    repository = mock(RepositoryExamImpl.class);
//    repositoryQuestion = mock(RepositoryQuestion.class);
//    service = new ServiceExamImpl(repository, repositoryQuestion);
  }

  @Test
  @DisplayName("Test With Data")
  void findByName_WithDataNotNull() {
    when(repository.findAll()).thenReturn(Data.EXAMS);

    assertDoesNotThrow(() -> {
      Exam exam = service.findByName("math");
      assertEquals(1L, exam.getId());
      assertEquals("math", exam.getName());
    });
  }

  @Test
  @DisplayName("Test without data")
  void findByName_WithNullData() {
    List<Exam> data = Collections.emptyList();
    when(repository.findAll()).thenReturn(data);

    assertThrows(NoSuchElementException.class, () -> {
      Exam exam = service.findByName("math");
    });
  }

  @Test
  @Disabled
  void test_ExamQuestions_WithValidQuestions() {
    when(repository.findAll()).thenReturn(Data.EXAMS);
    when(repositoryQuestion.findQuestionsByExamId(anyLong())).thenReturn(Data.QUESTIONS);

    assertDoesNotThrow(() -> {
      var exam = service.findExamByQuestionsName("math");
      assertEquals(3, exam.getQuestions().size());
      assertTrue(exam.getQuestions().contains("Calculus"));
    });
  }

  @Test
  void test_ExamQuestions_WithValidQuestions_Verify() {
    when(repository.findAll()).thenReturn(Data.EXAMS);
    when(repositoryQuestion.findQuestionsByExamId(anyLong())).thenReturn(Data.QUESTIONS);

    assertDoesNotThrow(() -> {
      var exam = service.findExamByQuestionsName("math");
      assertEquals(3, exam.getQuestions().size());
      assertTrue(exam.getQuestions().contains("Calculus"));
      // verify if the method is used
      verify(repository).findAll();
      verify(repositoryQuestion).findQuestionsByExamId(anyLong());
    });
  }

  @Test
  void test_ExamQuestions_WithThereIsNoVerifyExam_Verify() {
    when(repository.findAll()).thenReturn(Data.EXAMS);
//    when(repositoryQuestion.findQuestionsByExamId(anyLong())).thenReturn(Data.QUESTIONS);

    assertThrows(NoSuchElementException.class, () -> {
      var exam = service.findExamByQuestionsName("a");
      assertNull(exam);
      // verify if the method is used
    });
//    verify(repository).findAll();
//    verify(repositoryQuestion).findQuestionsByExamId(anyLong());
  }

  @Test
  void insert_StoreExam_ValidValue() {
//    GIVEN
    when(repository.store(any(Exam.class))).then(new Answer<Exam>() {
      Long sequence = 9L;

      @Override
      public Exam answer(InvocationOnMock invocationOnMock) throws Throwable {
        Exam exam = invocationOnMock.getArgument(0);
        exam.setId(sequence++);
        return exam;
      }
    });
//    WHEN
    Exam testExam = Data.EXAM;
    testExam.setQuestions(Data.QUESTIONS);
    Exam exam = service.store(testExam);
//    assertEquals(2, exam.getId());

//    THEN
    assertNotNull(exam.getId());

    verify(repository).store(any(Exam.class));
    verify(repositoryQuestion).storeList(anyList());
  }
}