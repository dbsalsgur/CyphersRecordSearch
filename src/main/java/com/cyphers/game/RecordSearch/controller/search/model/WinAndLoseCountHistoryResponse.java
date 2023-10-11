package com.cyphers.game.RecordSearch.controller.search.model;

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
public class WinAndLoseCountHistoryResponse {
	private Integer historyDate;
    private Integer winCount;
    private Integer loseCount;
}
