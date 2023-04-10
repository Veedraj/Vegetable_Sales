package com.vegetable.dto;

import javax.validation.constraints.NotBlank;

import com.vegetable.entity.Type;

public class PaymentDTO {

	@NotBlank(message="Type Should Not be Null or Blank")
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PaymentDTO [type=" + type + "]";
	}

	public PaymentDTO() {
		super();
	}

	public PaymentDTO(@NotBlank(message = "Type Should Not be Null or Blank") Type type) {
		super();
		this.type = type;
	}
}
