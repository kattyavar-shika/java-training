package com.kattyavar.shika.main.java.live_session.extra.bytewritte;

public final class Rock {
  private final String storageNumber;
  private final String rockSpecies;
  private final String weight;
  private final String description;

  public Rock(final String storageNumber, final String rockSpecies, final String weight, final String description) {
    this.storageNumber = storageNumber;
    this.rockSpecies = rockSpecies;
    this.weight = weight;
    this.description = description;
  }

  public final String getStorageNumber() {
    return storageNumber;
  }

  public final String getRockSpecies() {
    return rockSpecies;
  }

  public final String getWeight() {
    return weight;
  }

  public final String getDescription() {
    return description;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((rockSpecies == null) ? 0 : rockSpecies.hashCode());
    result = prime * result + ((storageNumber == null) ? 0 : storageNumber.hashCode());
    result = prime * result + ((weight == null) ? 0 : weight.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Rock other = (Rock) obj;
    if (rockSpecies == null) {
      if (other.rockSpecies != null) {
        return false;
      }
    } else if (!rockSpecies.equals(other.rockSpecies)) {
      return false;
    }
    if (storageNumber == null) {
      if (other.storageNumber != null) {
        return false;
      }
    } else if (!storageNumber.equals(other.storageNumber)) {
      return false;
    }
    if (weight == null) {
      if (other.weight != null) {
        return false;
      }
    } else if (!weight.equals(other.weight)) {
      return false;
    }
    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Rock [storageNumber=" + storageNumber + ", rockSpecies=" + rockSpecies + ", weight=" + weight + ", description=" + description + "]";
  }
}