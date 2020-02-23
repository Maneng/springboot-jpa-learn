package com.maneng.jpa.demo.foundation.base.utils;

/**
 * Created by jiangyu on 2016-01-07 00:22.
 */
public enum LengthUnit {

  MILLIMETER {
    public Number toMillimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length;
    }

    public Number toCentimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C1 / C0);
    }

    public Number toDecimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C2 / C0);
    }

    public Number toMeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C3 / C0);
    }

    public Number toKilometer(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C4 / C0);
    }

    public Number convert(Number length, LengthUnit u) {
      return u.toMillimeter(length);
    }
  }, CENTIMETER {
    public Number toMillimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C1 / C0, MAX / (C1 / C0));
    }

    public Number toCentimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length;
    }

    public Number toDecimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C2 / C1);
    }

    public Number toMeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C3 / C1);
    }

    public Number toKilometer(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C4 / C1);
    }

    public Number convert(Number length, LengthUnit u) {
      return u.toCentimeter(length);
    }
  }, DECIMETER {
    public Number toMillimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C2 / C0, MAX / (C2 / C0));
    }

    public Number toCentimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C2 / C1, MAX / (C2 / C1));
    }

    public Number toDecimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length;
    }

    public Number toMeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C3 / C2);
    }

    public Number toKilometer(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C4 / C2);
    }

    public Number convert(Number length, LengthUnit u) {
      return u.toDecimeter(length);
    }
  }, METER {
    public Number toMillimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C3 / C0, MAX / (C3 / C0));
    }

    public Number toCentimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C3 / C1, MAX / (C3 / C1));
    }

    public Number toDecimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C3 / C2, MAX / (C3 / C2));
    }

    public Number toMeter(Number length) {
      if (length == null) {
        return 0;
      }
      return length;
    }

    public Number toKilometer(Number length) {
      if (length == null) {
        return 0;
      }
      return length.doubleValue() / (double) (C4 / C3);
    }

    public Number convert(Number length, LengthUnit u) {
      return u.toMeter(length);
    }
  }, KILOMETER {
    public Number toMillimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C4 / C0, MAX / (C4 / C0));
    }

    public Number toCentimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C4 / C1, MAX / (C4 / C1));
    }

    public Number toDecimeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C4 / C2, MAX / (C4 / C2));
    }

    public Number toMeter(Number length) {
      if (length == null) {
        return 0;
      }
      return x(length, C4 / C3, MAX / (C4 / C3));
    }

    public Number toKilometer(Number length) {
      if (length == null) {
        return 0;
      }
      return length;
    }

    public Number convert(Number length, LengthUnit u) {
      return u.toKilometer(length);
    }
  };

  static final long C0 = 1L;
  static final long C1 = C0 * 10L;
  static final long C2 = C1 * 10L;
  static final long C3 = C2 * 10L;
  static final long C4 = C3 * 1000L;

  static final long MAX = Long.MAX_VALUE;


  static Number x(Number d, Number m, Number over) {
    if (d.doubleValue() > over.doubleValue()) {
      return Long.MAX_VALUE;
    }
    if (d.doubleValue() < -over.doubleValue()) {
      return Long.MIN_VALUE;
    }
    return d.doubleValue() * m.doubleValue();
  }

  public Number toMillimeter(Number length) {
    throw new AbstractMethodError();
  }

  public Number toCentimeter(Number length) {
    throw new AbstractMethodError();
  }

  public Number toDecimeter(Number length) {
    throw new AbstractMethodError();
  }

  public Number toMeter(Number length) {
    throw new AbstractMethodError();
  }

  public Number toKilometer(Number length) {
    throw new AbstractMethodError();
  }
}
