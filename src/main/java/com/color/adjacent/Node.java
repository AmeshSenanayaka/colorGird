package com.color.adjacent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.Color;
import java.util.Objects;

/* ==============================================================
 *  Author :Amesh Senanayaka
 *  Date   : 04/02/2022 - 19:01 PM
 *  Description :Grid Node Details
 * ==============================================================
 **/

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class Node {
	private int x;
	private int y;
	private Color color;
	private boolean isMark; // to easy to read in loop

	public Node (int x , int y , Color color2) {
		this.x = x;
		this.y = y;
		this.color = color2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Node node = (Node) o;
		return x == node.x && y == node.y && Objects.equals(color, node.color);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
