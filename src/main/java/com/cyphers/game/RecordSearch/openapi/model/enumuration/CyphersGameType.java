package com.cyphers.game.RecordSearch.openapi.model.enumuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CyphersGameType {
	RATING("rating"),
	NORMAL("normal"),;
	
	private String value;
	
    public String value() {
    	return value;
    }
}
