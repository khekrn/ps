package main

import (
	"fmt"

	"github.com/khekrn/ps/array"
)

func main() {
	arr := []int{0, 1, 2, 2, 3, 0, 4, 2}
	fmt.Println(array.RemoveElement(arr, 2))
	fmt.Println("Array ", arr)
}
