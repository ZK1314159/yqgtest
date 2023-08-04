package org.example.yqgtest.util.json;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlainDto {
  @JsonSerialize(using = ToStringSerializer.class)
  private Season season;
}
