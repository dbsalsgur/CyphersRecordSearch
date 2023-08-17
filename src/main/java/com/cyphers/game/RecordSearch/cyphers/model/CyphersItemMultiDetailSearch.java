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
public class CyphersItemMultiDetailSearch {
	private List<CyphersItemDetailInfo> rows;
}