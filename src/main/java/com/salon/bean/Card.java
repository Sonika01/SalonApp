/*********************************************************************************************
 * Description    : It is an entity class that has various data members
 *********************************************************************************************/

package com.salon.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long cardId;
	@NotNull
	private String cardName;
	
	@NotNull
	private String cardNumber;
	@NotNull
	@Pattern(regexp="^\\d{2}-\\d{4}$",message="The format of Card Expiry is MM-YYYY")
    private String cardExpiry;
	
	@NotNull
	@Size(min=3,max=3,message="cvv number should not be exceeded ")
    private String cvv;
	
	public Card() {
		
	}
	
	public Card(@NotNull String cardName, @NotNull String cardNumber, @NotNull String cardExpiry, @NotNull String cvv) {
		
		super();
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Card [ cardName=" + cardName + ", cardNumber=" + cardNumber + ", cardExpiry="
				+ cardExpiry + ", cvv=" + cvv + "]";
	}
 	
}


