package github.com.mohdaalam005.student.mapper;

import github.com.mohdaalam005.student.entity.StudentEntity;
import github.com.mohdaalam005.student.model.StudentRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StudentEntityMapper {
    StudentEntity toEntity(StudentRequest studentRequest);

    StudentRequest toDto(StudentEntity studentEntity);
    List<StudentRequest> toDtoS(List<StudentEntity> studentEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    StudentEntity partialUpdate(StudentRequest studentRequest, @MappingTarget StudentEntity studentEntity);
}