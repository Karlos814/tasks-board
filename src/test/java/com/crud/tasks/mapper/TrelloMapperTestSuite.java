package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TrelloMapperTestSuite {
    TrelloMapper trelloMapper = new TrelloMapper();

    List<TrelloList> trelloLists = new ArrayList<>();
    List<TrelloListDto> trelloListDto = new ArrayList<>();
    List<TrelloBoard> trelloBoards = new ArrayList<>();
    List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
    TrelloList trelloList = new TrelloList("list id", "list name", true);
    TrelloListDto listDto = new TrelloListDto("dto list id", "dto list name", true);
    TrelloBoard trelloBoard = new TrelloBoard("id", "name", trelloLists);
    TrelloBoardDto trelloBoardDto = new TrelloBoardDto("dto id", "dto name", trelloListDto);
    TrelloCard trelloCard = new TrelloCard("name Card", "Card description", "top", "id");
    TrelloCardDto trelloCardDto = new TrelloCardDto("name Card dto", "Card dto description", "dto top", "dto id");

    @Test
    public void testMapToBoards(){
        //Given
        trelloBoardDtoList.add(trelloBoardDto);

        //When
        List<TrelloBoard> testList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals("dto id", testList.get(0).getId());
        assertEquals("dto name", testList.get(0).getName());
    }

    @Test
    public void testMapToBoardsDto (){
        //Given
        trelloBoards.add(trelloBoard);

        //When
        List<TrelloBoardDto> testList = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals("id", testList.get(0).getId());
        assertEquals("name", testList.get(0).getName());
    }

    @Test
    public void testMapToList (){
        //Given
        trelloListDto.add(listDto);

        //When
        List<TrelloList> testList = trelloMapper.mapToList(trelloListDto);

        //Then
        assertEquals("dto list id", testList.get(0).getId());
        assertEquals("dto list name", testList.get(0).getName());
        assertEquals(true, testList.get(0).isClosed());
    }

    @Test
    public void testMapToListDto (){
        //Given
        trelloLists.add(trelloList);

        //When
        List<TrelloListDto> testList = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals("list id", testList.get(0).getId());
        assertEquals("list name", testList.get(0).getName());
        assertEquals(true, testList.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto (){
        //Given
        //When
        TrelloCardDto testCard = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("name Card", testCard.getName());
        assertEquals("Card description", testCard.getDescription());
        assertEquals("top", testCard.getPos());
        assertEquals("id", testCard.getListId());
    }

    @Test
    public void testMapToCard(){
        //Given
        //When
        TrelloCard testCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("name Card dto", testCard.getName());
        assertEquals("Card dto description", testCard.getDescription());
        assertEquals("dto top", testCard.getPos());
        assertEquals("dto id", testCard.getListId());
    }
}
