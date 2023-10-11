package com.cyphers.game.RecordSearch.controller.search.model;

import java.time.LocalDateTime;
import java.util.List;

import com.cyphers.game.RecordSearch.model.CrsMostPositionInfos;

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
public class SearchDetailResponse {
//	private IoSearchDetailResponse detailResponse;
//	private CrsDetailSearch crsDetailSearch;
	private String playerId;
	private String profileCharacterId;
	private String nickname;
	
	private LocalDateTime recentlyUpdatedDate;
	
	private List<MostCypherInfoResponse> mostCypherInfos;
    private MostPositionInfoResponse mostPositionInfos;

    private String ratingGameTier;
    private Integer ratingWinCount;
    private Integer ratingLoseCount;
    private Integer ratingStopCount;
    private Integer ratingWinRate;

    private Integer normalWinCount;
    private Integer normalLoseCount;
    private Integer normalStopCount;
    private Integer normalWinRate;
    
    private List<WinAndLoseCountHistoryResponse> winAndLoseCountHistory;

    private Integer recentlyPlayCount;
    private Integer recentlyWinRate;
    private Float recentlyKda;
    private Integer recentlyAverageSurvivalRate;	
    
    private List<RecentlyPlayCypherInfoResponse> recentlyPlayCyphersInfos;

    private List<IoSearchDetailGameRecord> gameRecords;
}