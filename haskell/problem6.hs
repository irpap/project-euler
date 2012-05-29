sumOfSquares::[Int] -> Int
sumOfSquares xs = sum [square x | x <- xs ]

squareOfSums:: [Int] -> Int
squareOfSums xs = square $ last xs * (last xs + 1) `div` 2

square:: Num a=> a -> a
square x = x * x

main = do
    print $ squareOfSums [1..100] - sumOfSquares [1..100]