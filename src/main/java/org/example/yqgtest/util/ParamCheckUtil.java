package org.example.yqgtest.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ParamCheckUtil {

  private final SpringValidatorAdapter validator;

  public Result validate(Object param) {
    Errors errors = new BeanPropertyBindingResult(param, "param");
    validator.validate(param, errors);
    Result result = Result.builder().build();
    if (errors.hasErrors()) {
      result.setSuccess(false);
      result.setMessage(getMessage(errors.getAllErrors()));
    } else {
      result.setSuccess(true);
    }
    return result;
  }

  private String getMessage(List<ObjectError> errors) {
    List<String> msg = new ArrayList<>();
    for (ObjectError error : errors) {
      if (error instanceof FieldError) {
        FieldError fieldError = (FieldError) error;
        msg.add(fieldError.getField() + error.getDefaultMessage());
      }
    }
    return StringUtils.join(msg, ",");
  }

  @Data
  @Builder
  public static class Result {
    private boolean success;
    private String message;
  }

  @Data
  @Builder
  public static class Param {
    @NotNull
    private Integer id;
    @NotBlank(message = "name不能为空啊")
    private String name;
    @NotEmpty
    private List<Integer> values;
  }

}
