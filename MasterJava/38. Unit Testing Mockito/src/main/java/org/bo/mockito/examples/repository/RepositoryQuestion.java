package org.bo.mockito.examples.repository;

import java.util.List;

public interface RepositoryQuestion {
  List<String> findQuestionsByExamId(long id);

  void storeList(List<String> questions);
}
