/* (C) 2023 */
package com.slalombuild.projectman.usecase;

import com.slalombuild.projectman.domain.repository.ProjectRepository;
import com.slalombuild.projectman.usecase.model.GetProjectResult;
import com.slalombuild.projectman.usecase.model.ProjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllProjectsUseCase {
  @NonNull private ProjectRepository projectRepository;

  public GetProjectResult getAllProjects() {
    var allProjects = projectRepository.findAll();

    var viewModels = allProjects.stream().map(ProjectMapper.INSTANCE::toViewModel).toList();

    return new GetProjectResult(viewModels);
  }
}
