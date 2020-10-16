package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskMapperTestSuite {

    TaskMapper myMapper = new TaskMapper();

    Task task = new Task(1L, "name", "description");
    TaskDto taskDto = new TaskDto(9L, "dto name", "dto description");

    @Test
    public void testMapToTask() {
        //Given
        //When
        Task testTask = myMapper.mapToTask(taskDto);

        //Then
        assertEquals(9L, testTask.getId());
        assertEquals("dto name", testTask.getTitle());
        assertEquals("dto description", testTask.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        //When
        TaskDto testTaskDto = myMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, testTaskDto.getId());
        assertEquals("name", testTaskDto.getTitle());
        assertEquals("description", testTaskDto.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskList.add(task);
        taskDtoList.add(taskDto);

        //When
        List<TaskDto> testList = myMapper.mapToTaskDtoList(taskList);

        //Then
        assertNotNull(testList);
        assertEquals(1, testList.size());
        assertEquals(1L, testList.get(0).getId());
        assertEquals("name", testList.get(0).getTitle());
        assertEquals("description", testList.get(0).getContent());
    }
}