package com.maneng.jpa.demo.foundation.base.error;

/**
 * Created by jiangyu on 2015-10-21 15:41.
 */
public class ErrorsBuilder {

  private ErrorsBuilder() {
  }

  public static LevelBuilder create() {
    return new LevelBuilder(new Errors());
  }

  static class CloneError {

    protected Errors errors;

    public CloneError(Errors errors) {
      if (errors == null) {
        errors = new Errors();
      }
      this.errors = errors;
    }
  }

  public static class LevelBuilder extends CloneError {

    public LevelBuilder(Errors errors) {
      super(errors);
    }

    public FinalBuilder warning() {
      errors.setLevelType(LevelType.WARNING);
      return new FinalBuilder(errors);
    }

    public FinalBuilder error() {
      errors.setLevelType(LevelType.ERROR);
      return new FinalBuilder(errors);
    }
  }

  public static class FinalBuilder extends CloneError {

    public FinalBuilder(Errors errors) {
      super(errors);
    }

    public FinalBuilder code(Code code) {
      errors.setCode(code);
      return this;
    }

    public FinalBuilder code(int code, String message) {
      errors.setCode(code, message);
      return this;
    }

    public FinalBuilder series(SeriesType seriesType) {
      errors.setSeriesType(seriesType);
      return this;
    }

    public Errors build() {
      return errors;
    }

  }


}
