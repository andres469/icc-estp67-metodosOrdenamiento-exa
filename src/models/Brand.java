package models;

public class Brand {
  private String BrandName;
  private CarModel[] models;

  public Brand(String name, CarModel[] models) {
    this.BrandName = name;
    this.models = models;
  }

  public String getBrandName() {
    return BrandName;
  }

  public void setBrandName(String name) {
    this.BrandName = name;
  }

  public CarModel[] getModels() {
    return models;
  }

  public void setModels(CarModel[] models) {
    this.models = models;
  }

  public int getTotalValidYears() {
    int total = 0;
    for (CarModel carModel : models) {
      for (CarYear year : carModel.getYears()) {
        if (year.isValid()) {
          total++;
        }
      }
    }
    return total;
  }

}
