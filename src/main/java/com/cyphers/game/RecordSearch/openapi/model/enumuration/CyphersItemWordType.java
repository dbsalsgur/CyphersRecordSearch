package com.cyphers.game.RecordSearch.openapi.model.enumuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CyphersItemWordType {
    MATCH("match"),
    FULL("full"),
	FRONT("front"),;

    private String value;
    
}
