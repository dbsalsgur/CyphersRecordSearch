package com.cyphers.game.RecordSearch.openapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CyphersPlayerRankInfo {
	private Integer rank;
	private Integer beforeRank;
	private String playerId;
	private String nickname;
	private Integer grade;
	private Integer ratingPoint;
	private String clanName;
	private CyphersPlayerRepresent represent;
}
