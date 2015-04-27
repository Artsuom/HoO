package com.artsuo.hallsofosiris.objects.components;

public class Stats {

	private int currHealth;
	private int maxHealth;
	
	public Stats(int maxHealth) {
		this.maxHealth = maxHealth;
		this.currHealth = this.maxHealth;
	}
	
	public int getCurrHealth() {
		return currHealth;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public boolean damage(int damage) {
		currHealth -= damage;
		if (currHealth <= 0) {
			return false;
		}
		return true;
	}
}
