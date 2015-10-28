import Text.Printf

type Point     = (Float,Float)
type Rect      = (Point,Float,Float)

-- Gera retangulo SVG 
-- a partir de coordenadas+dimensoes e de uma string com atributos de estilo
writeRect :: (String,Rect) -> String 
writeRect (style,((x,y),w,h)) = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />\n" x y w h style

-- Gera codigo-fonte de arquivo SVG 
-- concatenando uma lista de retangulos e seus atributos de estilo
writeRects :: [(String,Rect)] -> String 
writeRects rs = (concatMap writeRect rs) 


doRectangle :: Float -> Float -> Float -> Float -> Float -> Float -> Float -> [(String,Rect)]
doRectangle lineNumber columnNumber rectWidth rectHeight hue xStart yStart =
  let --Lista com os valores de sat e light
    sat = [100, 100 - (100.0 / (columnNumber - 1))..0]
    light = [100, 100 - (100.0 / (lineNumber - 1))..0]

    --Forma uma lista de tuplas com os valores de sat e light
    satLight = [(s, l) | s <- sat, l <- light]

    --Forma uma lista de strings com os valores de hue, sat, light
    colors = map(\sl -> "fill:hsl(" ++ show(hue) ++ ", " ++ show(fst sl) ++ "%, " ++ show(snd sl) ++ "%)") satLight
    
    --Forma listas com valores de x e y
    xs = if(columnNumber == 1) then [xStart] else if (columnNumber == 2) then [xStart, xStart + rectWidth + 15] else [xStart,xStart + rectWidth + 5..((columnNumber - 1) * (rectWidth + 5)) + xStart]
    ys = if(lineNumber == 1) then [yStart] else if (lineNumber == 2) then [yStart, xStart + rectHeight + 15] else [yStart,yStart + rectHeight + 5..((lineNumber - 1) * (rectHeight + 5)) + yStart]
    
    --Concatena as strings de estilos com as coordenadas x, y
    rect = [(((x,y),rectWidth,rectHeight)) | x <- xs, y <- ys]
  in zip colors rect

main :: IO ()
main = do
  let
    xStart = 10
    yStart = 10
    lineNumber = 10
    columnNumber = 10
    rectWidth = 50
    rectHeight = 25
    hue = 180

    xStart1 = (rectWidth + 5) * columnNumber + 50
    yStart1 = 10
    lineNumber1 = 10
    columnNumber1 = 10
    rectWidth1 = 75
    rectHeight1 = 25
    hue1 = 0
    
    --String que contém os <rect>
    svg = (writeRects (doRectangle lineNumber columnNumber rectWidth rectHeight hue xStart yStart)) ++ (writeRects (doRectangle lineNumber1 columnNumber1 rectWidth1 rectHeight1 hue1 xStart1 yStart1))

    --Define o tamanho do <svg>
    (w,h) = (xStart1 + ((rectWidth1 + 5) * columnNumber1), yStart1 + ((rectWidth + 5) * lineNumber))
    
  writeFile "colors.svg" $ (printf "<svg width='%.2f' height='%.2f' style='background:gray' xmlns='http://www.w3.org/2000/svg'>\n" w h) ++ svg ++ "</svg>"