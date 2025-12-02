package controllers;

import models.Brand;

public class BrandController {

  public Brand[] sortBubbleDesc(Brand[] brands) {
    int n = brands.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (brands[j].getTotalValidYears() < brands[j + 1].getTotalValidYears()) {
          Brand temp = brands[j];
          brands[j] = brands[j + 1];
          brands[j + 1] = temp;
        }
      }
    }
    return brands;
  }

  public Brand binarySearchByValidYears(Brand[] brands, int validYear, boolean isAscending) {
    int left = 0;
    int right = brands.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      int midValue = brands[mid].getTotalValidYears();
      if (midValue == validYear) {
        return brands[mid];
      }
      if (isAscending) {
        if (validYear < midValue) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (validYear > midValue) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return null;
  }

}
