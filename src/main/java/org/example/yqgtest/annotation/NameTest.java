package org.example.yqgtest.annotation;

import com.yqg.core.util.exception.YqgException;
import com.yqg.core.util.exception.YqgExceptionType;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NameTest {

  public static void main(String[] args) {
    Class<NameDto> nameDtoClass = NameDto.class;
    String name = getName(nameDtoClass, "姓名");
    Comparator.comparing()
  }

  private static String getName(Class<?> clazz, String name) {
    List<String> fieldName = Arrays.stream(clazz.getDeclaredFields())
      .filter(v -> existAnnotation(v, name))
      .map(Field::getName)
      .collect(Collectors.toList());
    if (fieldName.isEmpty()) {
      throw new YqgException(YqgExceptionType.COMMON_SERVER_ERROR, "找不到对应的字段");
    }
    if (fieldName.size() > 1) {
      throw new YqgException(YqgExceptionType.COMMON_SERVER_ERROR, "找到多个对应的字段");
    }
    return fieldName.get(0);
  }

  private static boolean existAnnotation(Field field, String name) {
    return Optional.ofNullable(field.getAnnotation(Name.class))
      .map(Name::value)
      .filter(StringUtils::isNotBlank)
      .filter(v -> v.equals(name))
      .isPresent();
  }

}
