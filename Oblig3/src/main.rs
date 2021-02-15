fn main() {
    println!("Hello world");

    let start = 0;
    let end = 100;

    for i in start..end{
        if is_prime(i){
            println!("{}", i);
        }
    }
}

fn is_prime(num: u32) -> bool {
    if num>1 {
      for i in 2..num {
            if num % i == 0 {
                return false;
            }
        }
        return true;
        }
    else {
        return false;
    }
    } 



