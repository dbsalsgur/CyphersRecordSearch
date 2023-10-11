package com.cyphers.game.RecordSearch.controller.search.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameRecordResponse {
	
	private List<IoSearchDetailGameRecord> gameRecords;
	
}
