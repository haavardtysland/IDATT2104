pub fn run(num: i32) -> i32 {
    if num>1 {
      for i in 2..num {
            if num % i == 0 {
                return 0;
            }
        }
        return num;
        }
    else {
        return 0;
    }
    } 
