package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.OrderRequest;
import io.swagger.model.OutlierHistory;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OutlierdetectionAnalyzeorderBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-05-14T12:14:50.777488516Z[GMT]")


public class OutlierdetectionAnalyzeorderBody   {
  @JsonProperty("OrderRequest")
  private OrderRequest orderRequest = null;

  @JsonProperty("OutlierHistory")
  private OutlierHistory outlierHistory = null;

  public OutlierdetectionAnalyzeorderBody orderRequest(OrderRequest orderRequest) {
    this.orderRequest = orderRequest;
    return this;
  }

  /**
   * Get orderRequest
   * @return orderRequest
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OrderRequest getOrderRequest() {
    return orderRequest;
  }

  public void setOrderRequest(OrderRequest orderRequest) {
    this.orderRequest = orderRequest;
  }

  public OutlierdetectionAnalyzeorderBody outlierHistory(OutlierHistory outlierHistory) {
    this.outlierHistory = outlierHistory;
    return this;
  }

  /**
   * Get outlierHistory
   * @return outlierHistory
   **/
  @Schema(description = "")
  
    @Valid
    public OutlierHistory getOutlierHistory() {
    return outlierHistory;
  }

  public void setOutlierHistory(OutlierHistory outlierHistory) {
    this.outlierHistory = outlierHistory;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OutlierdetectionAnalyzeorderBody outlierdetectionAnalyzeorderBody = (OutlierdetectionAnalyzeorderBody) o;
    return Objects.equals(this.orderRequest, outlierdetectionAnalyzeorderBody.orderRequest) &&
        Objects.equals(this.outlierHistory, outlierdetectionAnalyzeorderBody.outlierHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderRequest, outlierHistory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OutlierdetectionAnalyzeorderBody {\n");
    
    sb.append("    orderRequest: ").append(toIndentedString(orderRequest)).append("\n");
    sb.append("    outlierHistory: ").append(toIndentedString(outlierHistory)).append("\n");
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
