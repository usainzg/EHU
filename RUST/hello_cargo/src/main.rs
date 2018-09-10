#[derive(Debug)]
struct Point {
    x: i32
}

fn main() {
    let point = {
        x: 24
    };
    
    println!("{:#?}", point);
}
