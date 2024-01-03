package com.prudhvi.leetcode.january;



public class Jan_3_2125_Number_of_Laser_Beams_Bank {

	public static void main(String[] args) {
		String[] bank = {"011001","000000","010100","001000"}; 
		System.out.println(numberOfBeams(bank));
	}
	/*
	Time Complexity:
			1. The `numberOfBeams` function iterates through each row in the `bank` array using a for-each loop. In the worst case, it goes through all rows, so the time complexity is O(M), where M is the number of rows in the `bank` array.
			2. Inside the loop, the `countSecurityDevices` function is called for each row. It iterates through each character in the row, and in the worst case, it goes through all characters. Therefore, the time complexity of `countSecurityDevices` is O(N), where N is the length of each row.
		Overall, the time complexity of the entire code is O(M * N), where M is the number of rows and N is the length of each row.
	
	Space Complexity:
			The space complexity is determined by the variables used in the functions. In this case, the space complexity is relatively low:
				1. The `totalLaserBeams`, `prevDeviceCount`, `currentDeviceCount`, and `securityDevices` variables are integers and use constant space.
				2. The `row` variable in the for-each loop represents each row, but it doesn't use additional space proportional to the input.
		Therefore, the space complexity of the given code is O(1), constant space.
	In summary, the time complexity is O(M * N), and the space complexity is O(1).
	 */
	public static int numberOfBeams(String[] bank) {
		int totalLaserBeams = 0;
		int prevDeviceCount = 0;

		// Iterate through each row in the bank
		for (String row : bank) {
			// Count the number of security devices ('1') in the current row
			int currentDeviceCount = countSecurityDevices(row);

			// If there are security devices in the current row
			if (currentDeviceCount > 0) {
				// Calculate the total laser beams by multiplying the count of devices in the
				// current and previous rows
				totalLaserBeams += (prevDeviceCount * currentDeviceCount);
				prevDeviceCount = currentDeviceCount; // Update the count for the next iteration
			}
		}

		return totalLaserBeams;
	}

	public static int countSecurityDevices(String row) {
		int securityDevices = 0;

		// Iterate through each character in the row
		for (char ch : row.toCharArray()) {
			// Count the number of security devices ('1')
			securityDevices = (ch == '1') ? (securityDevices + 1) : securityDevices;
		}

		return securityDevices;
	}
	
	
	
	
	

	// SC = O(n)
	public static int numberOfBeamsSCn(String[] bank) {
		int n = bank.length;
		int[] securityDevice = new int[n];
		for (int i = 0; i < n; i++) {
			String row = bank[i];
			int deviceCount = 0;
			for (int j = 0; j < row.length(); j++) {
				if (row.charAt(j) == '1')
					deviceCount++;
			}
			securityDevice[i] = deviceCount;
		}

		int laserBeams = 0;
		for (int i = 0; i < n; i++) {
			if (securityDevice[i] != 0) {
				int j = i + 1;
				while (j < n && securityDevice[j] == 0) j++;
				if (j < n && securityDevice[j] != 0) 
					laserBeams += (securityDevice[i] * securityDevice[j]);
			}
		}
		return laserBeams;

	}

}
