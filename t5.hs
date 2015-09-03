--1
addSuffix :: String -> [String] -> [String]
addSuffix suffix str = [x ++ suffix | x <- str]

--2
addSuffix' :: String -> [String] -> [String]
addSuffix' _ [] = []
addSuffix' suffix (x:xs) = (x ++ suffix) : addSuffix suffix xs 