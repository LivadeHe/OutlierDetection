package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-05-14T12:14:50.777488516Z[GMT]")


public class OrderItem   {
  @JsonProperty("item_id")
  @NotNull(message = "item_id is required")
  @Pattern(regexp = "^[A-Za-z0-9]+$", message = "item_id must be alphanumeric")
  private String itemId = null;

  @JsonProperty("size")
  @Pattern(regexp = "^[A-Za-z0-9]+$", message = "size must be alphanumeric")
  private String size = null;

  @JsonProperty("color")
  @Pattern(regexp = "^[A-Za-z0-9]+$", message = "icolor must be alphanumeric")
  private String color = null;

  @JsonProperty("brand")
  @Pattern(regexp = "^[A-Za-z0-9]+$", message = "brand must be alphanumeric")
  private String brand = null;

  @JsonProperty("collection")
  @Pattern(regexp = "^[A-Za-z0-9]+$", message = "collection must be alphanumeric")
  private String collection = null;

  @JsonProperty("quantity")
  @NotNull(message = "quantity is required")
  @Min(value = 0, message = "quantity must be 0 or positive")
  private Integer quantity = null;

  @JsonProperty("attribute_x")
  @Pattern(regexp = "^[A-Za-z0-9]+$", message = "attribute_x must be alphanumeric")
  private String attributeX = null;

  @JsonProperty("attribute_y")
  @Pattern(regexp = "^[A-Za-z0-9]+$", message = "attribute_y must be alphanumeric")
  private String attributeY = null;

  @JsonProperty("attribute_z")
  @Min(value = 0, message = "attribute_z must be 0 or positive")
  private Integer attributeZ = null;

  public OrderItem itemId(String itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * The product item number
   * @return itemId
   **/
  @Schema(description = "The product item number")
  
    public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public OrderItem size(String size) {
    this.size = size;
    return this;
  }

  /**
   * The size of the product
   * @return size
   **/
  @Schema(description = "The size of the product")
  
    public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public OrderItem color(String color) {
    this.color = color;
    return this;
  }

  /**
   * The color of the product
   * @return color
   **/
  @Schema(description = "The color of the product")
  
    public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public OrderItem brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * The brand of the product
   * @return brand
   **/
  @Schema(description = "The brand of the product")
  
    public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public OrderItem collection(String collection) {
    this.collection = collection;
    return this;
  }

  /**
   * The collection to which the product belongs
   * @return collection
   **/
  @Schema(description = "The collection to which the product belongs")
  
    public String getCollection() {
    return collection;
  }

  public void setCollection(String collection) {
    this.collection = collection;
  }

  public OrderItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * The ordered quantity of the product
   * @return quantity
   **/
  @Schema(description = "The ordered quantity of the product")
  
    public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderItem attributeX(String attributeX) {
    this.attributeX = attributeX;
    return this;
  }

  /**
   * Further attributes of the product
   * @return attributeX
   **/
  @Schema(description = "Further attributes of the product")
  
    public String getAttributeX() {
    return attributeX;
  }

  public void setAttributeX(String attributeX) {
    this.attributeX = attributeX;
  }

  public OrderItem attributeY(String attributeY) {
    this.attributeY = attributeY;
    return this;
  }

  /**
   * Further attributes of the product
   * @return attributeY
   **/
  @Schema(description = "Further attributes of the product")
  
    public String getAttributeY() {
    return attributeY;
  }

  public void setAttributeY(String attributeY) {
    this.attributeY = attributeY;
  }

  public OrderItem attributeZ(Integer attributeZ) {
    this.attributeZ = attributeZ;
    return this;
  }

  /**
   * Further attributes of the product
   * @return attributeZ
   **/
  @Schema(description = "Further attributes of the product")
  
    public Integer getAttributeZ() {
    return attributeZ;
  }

  public void setAttributeZ(Integer attributeZ) {
    this.attributeZ = attributeZ;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(this.itemId, orderItem.itemId) &&
        Objects.equals(this.size, orderItem.size) &&
        Objects.equals(this.color, orderItem.color) &&
        Objects.equals(this.brand, orderItem.brand) &&
        Objects.equals(this.collection, orderItem.collection) &&
        Objects.equals(this.quantity, orderItem.quantity) &&
        Objects.equals(this.attributeX, orderItem.attributeX) &&
        Objects.equals(this.attributeY, orderItem.attributeY) &&
        Objects.equals(this.attributeZ, orderItem.attributeZ);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, size, color, brand, collection, quantity, attributeX, attributeY, attributeZ);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    collection: ").append(toIndentedString(collection)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    attributeX: ").append(toIndentedString(attributeX)).append("\n");
    sb.append("    attributeY: ").append(toIndentedString(attributeY)).append("\n");
    sb.append("    attributeZ: ").append(toIndentedString(attributeZ)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
