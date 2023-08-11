package com.cyphers.game.RecordSearch.cyphers.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CyphersMatchingHistory {
	private String playerId;
	private String nickname;
	private Integer grade;
	private Boolean tierTest;
	private CyphersPlayerRepresent represent;
	private String clanName;
	private Integer ratingPoint;
	private Integer maxRatingPoint;
	private String tierName;
	private List<CyphersRecords> records;
	private CyphersMatches matches;
}
