package fr.ubisoft.bls.test;

import fr.ubisoft.bls.main.LicenseAPI;
import fr.ubisoft.bls.main.LicenseAPI.LicenseState;

public class Main {
	
	public static void main(String[] args) {
		if (LicenseAPI.getState() == LicenseState.VAILD) {
			System.out.println("Baguette passed the border");
		} else {
			System.out.println("Baguette didnt pass the border :c");
		}
	}
}
