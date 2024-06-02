package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.OrderItem;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-05-14T12:14:50.777488516Z[GMT]")


public class OrderRequest {
    @JsonProperty("customer_id")
    @NotNull(message = "customer_id is required")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "customer_id must be alphanumeric")
    private String customerId = null;

    @JsonProperty("order_id")
    @NotNull(message = "order_id is required")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "order_id must be alphanumeric")
    private String orderId = null;

    @JsonProperty("order_date")
    @NotNull(message = "order_date is required")
    private OffsetDateTime orderDate = null;



    @JsonProperty("min_outlier_percentage")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2, message = "min_outlier_percentage must be a digit")
    @Min(value = 0, message = "min_outlier_percentage must be 0 or positive")
    @Valid
    private Integer minOutlierPercentage = null;

    @JsonProperty("items")
    @NotEmpty(message = "items cannot be null or empty")
    @Valid
    private List<OrderItem> items;

    @JsonProperty("timestamp")
    @NotNull(message = "timestamp is required")
    private OffsetDateTime timestamp = null;

    public OrderRequest customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * The unique customer ID
     *
     * @return customerId
     **/
    @Schema(description = "The unique customer ID")

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public OrderRequest orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * The unique order ID
     *
     * @return orderId
     **/
    @Schema(description = "The unique order ID")

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderRequest orderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public OrderRequest timestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }



    /**
     * Date and time when the order was placed
     *
     * @return orderDate
     **/
    @Schema(description = "Date and time when the order was placed")

    @Valid
    public OffsetDateTime getOrderDate() {
        return orderDate;
    }


    @Valid
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setOrderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderRequest minOutlierPercentage(Integer minOutlierPercentage) {
        this.minOutlierPercentage = minOutlierPercentage;
        return this;
    }

    /**
     * The minimum percentage required to classify an order as an outlier
     *
     * @return minOutlierPercentage
     **/
    @Schema(description = "The minimum percentage required to classify an order as an outlier")

    public Integer getMinOutlierPercentage() {
        return minOutlierPercentage;
    }

    public void setMinOutlierPercentage(Integer minOutlierPercentage) {
        this.minOutlierPercentage = minOutlierPercentage;
    }

    public OrderRequest items(List<OrderItem> items) {
        this.items = items;
        return this;
    }

    public OrderRequest addItemsItem(OrderItem itemsItem) {
        if (this.items == null) {
            this.items = new ArrayList<OrderItem>();
        }
        this.items.add(itemsItem);
        return this;
    }

    /**
     * Get items
     *
     * @return items
     **/
    @Schema(description = "")
    @Valid
    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderRequest orderRequest = (OrderRequest) o;
        return Objects.equals(this.customerId, orderRequest.customerId) &&
                Objects.equals(this.orderId, orderRequest.orderId) &&
                Objects.equals(this.orderDate, orderRequest.orderDate) &&
                Objects.equals(this.minOutlierPercentage, orderRequest.minOutlierPercentage) &&
                Objects.equals(this.items, orderRequest.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, orderId, orderDate, minOutlierPercentage, items, timestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OrderRequest {\n");

        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
        sb.append("    minOutlierPercentage: ").append(toIndentedString(minOutlierPercentage)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
