(ns happygapi2.slides
  "Google Slides API
Reads and writes Google Slides presentations.
See: https://developers.google.com/slides/"
  (:require [happy.oauth2.client :as client]))

(defn presentations-get
  "Gets the latest version of the specified presentation.
https://developers.google.com/slides/reference/rest/v1/presentations/get

presentationId <string> The ID of the presentation to retrieve."
  [presentationId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://slides.googleapis.com/v1/presentations/{+presentationId}",
     :uri-template-args {:presentationId presentationId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/presentations"
      "https://www.googleapis.com/auth/presentations.readonly"]}))

(defn presentations-create
  "Creates a blank presentation using the title given in the request. If a `presentationId` is provided, it is used as the ID of the new presentation. Otherwise, a new ID is generated. Other fields in the request, including any provided content, are ignored. Returns the created presentation.
https://developers.google.com/slides/reference/rest/v1/presentations/create

Presentation:
{:locale string,
 :notesMaster
 {:notesProperties {:speakerNotesObjectId string},
  :objectId string,
  :revisionId string,
  :pageElements
  [{:description string,
    :video
    {:url string,
     :source [SOURCE_UNSPECIFIED YOUTUBE DRIVE],
     :id string,
     :videoProperties
     {:outline Outline,
      :autoPlay boolean,
      :start integer,
      :end integer,
      :mute boolean}},
    :sheetsChart
    {:spreadsheetId string,
     :chartId integer,
     :contentUrl string,
     :sheetsChartProperties {:chartImageProperties ImageProperties}},
    :speakerSpotlight
    {:speakerSpotlightProperties {:outline Outline, :shadow Shadow}},
    :transform
    {:scaleX number,
     :scaleY number,
     :shearX number,
     :shearY number,
     :translateX number,
     :translateY number,
     :unit [UNIT_UNSPECIFIED EMU PT]},
    :table
    {:rows integer,
     :columns integer,
     :tableRows
     [{:rowHeight Dimension,
       :tableRowProperties TableRowProperties,
       :tableCells [TableCell]}],
     :tableColumns [{:columnWidth Dimension}],
     :horizontalBorderRows [{:tableBorderCells [TableBorderCell]}],
     :verticalBorderRows [{:tableBorderCells [TableBorderCell]}]},
    :objectId string,
    :size
    {:width {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
     :height {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]}},
    :title string,
    :line
    {:lineProperties
     {:lineFill LineFill,
      :weight Dimension,
      :dashStyle
      [DASH_STYLE_UNSPECIFIED
       SOLID
       DOT
       DASH
       DASH_DOT
       LONG_DASH
       LONG_DASH_DOT],
      :startArrow
      [ARROW_STYLE_UNSPECIFIED
       NONE
       STEALTH_ARROW
       FILL_ARROW
       FILL_CIRCLE
       FILL_SQUARE
       FILL_DIAMOND
       OPEN_ARROW
       OPEN_CIRCLE
       OPEN_SQUARE
       OPEN_DIAMOND],
      :endArrow
      [ARROW_STYLE_UNSPECIFIED
       NONE
       STEALTH_ARROW
       FILL_ARROW
       FILL_CIRCLE
       FILL_SQUARE
       FILL_DIAMOND
       OPEN_ARROW
       OPEN_CIRCLE
       OPEN_SQUARE
       OPEN_DIAMOND],
      :link Link,
      :startConnection LineConnection,
      :endConnection LineConnection},
     :lineType
     [TYPE_UNSPECIFIED
      STRAIGHT_CONNECTOR_1
      BENT_CONNECTOR_2
      BENT_CONNECTOR_3
      BENT_CONNECTOR_4
      BENT_CONNECTOR_5
      CURVED_CONNECTOR_2
      CURVED_CONNECTOR_3
      CURVED_CONNECTOR_4
      CURVED_CONNECTOR_5
      STRAIGHT_LINE],
     :lineCategory [LINE_CATEGORY_UNSPECIFIED STRAIGHT BENT CURVED]},
    :shape
    {:shapeType
     [TYPE_UNSPECIFIED
      TEXT_BOX
      RECTANGLE
      ROUND_RECTANGLE
      ELLIPSE
      ARC
      BENT_ARROW
      BENT_UP_ARROW
      BEVEL
      BLOCK_ARC
      BRACE_PAIR
      BRACKET_PAIR
      CAN
      CHEVRON
      CHORD
      CLOUD
      CORNER
      CUBE
      CURVED_DOWN_ARROW
      CURVED_LEFT_ARROW
      CURVED_RIGHT_ARROW
      CURVED_UP_ARROW
      DECAGON
      DIAGONAL_STRIPE
      DIAMOND
      DODECAGON
      DONUT
      DOUBLE_WAVE
      DOWN_ARROW
      DOWN_ARROW_CALLOUT
      FOLDED_CORNER
      FRAME
      HALF_FRAME
      HEART
      HEPTAGON
      HEXAGON
      HOME_PLATE
      HORIZONTAL_SCROLL
      IRREGULAR_SEAL_1
      IRREGULAR_SEAL_2
      LEFT_ARROW
      LEFT_ARROW_CALLOUT
      LEFT_BRACE
      LEFT_BRACKET
      LEFT_RIGHT_ARROW
      LEFT_RIGHT_ARROW_CALLOUT
      LEFT_RIGHT_UP_ARROW
      LEFT_UP_ARROW
      LIGHTNING_BOLT
      MATH_DIVIDE
      MATH_EQUAL
      MATH_MINUS
      MATH_MULTIPLY
      MATH_NOT_EQUAL
      MATH_PLUS
      MOON
      NO_SMOKING
      NOTCHED_RIGHT_ARROW
      OCTAGON
      PARALLELOGRAM
      PENTAGON
      PIE
      PLAQUE
      PLUS
      QUAD_ARROW
      QUAD_ARROW_CALLOUT
      RIBBON
      RIBBON_2
      RIGHT_ARROW
      RIGHT_ARROW_CALLOUT
      RIGHT_BRACE
      RIGHT_BRACKET
      ROUND_1_RECTANGLE
      ROUND_2_DIAGONAL_RECTANGLE
      ROUND_2_SAME_RECTANGLE
      RIGHT_TRIANGLE
      SMILEY_FACE
      SNIP_1_RECTANGLE
      SNIP_2_DIAGONAL_RECTANGLE
      SNIP_2_SAME_RECTANGLE
      SNIP_ROUND_RECTANGLE
      STAR_10
      STAR_12
      STAR_16
      STAR_24
      STAR_32
      STAR_4
      STAR_5
      STAR_6
      STAR_7
      STAR_8
      STRIPED_RIGHT_ARROW
      SUN
      TRAPEZOID
      TRIANGLE
      UP_ARROW
      UP_ARROW_CALLOUT
      UP_DOWN_ARROW
      UTURN_ARROW
      VERTICAL_SCROLL
      WAVE
      WEDGE_ELLIPSE_CALLOUT
      WEDGE_RECTANGLE_CALLOUT
      WEDGE_ROUND_RECTANGLE_CALLOUT
      FLOW_CHART_ALTERNATE_PROCESS
      FLOW_CHART_COLLATE
      FLOW_CHART_CONNECTOR
      FLOW_CHART_DECISION
      FLOW_CHART_DELAY
      FLOW_CHART_DISPLAY
      FLOW_CHART_DOCUMENT
      FLOW_CHART_EXTRACT
      FLOW_CHART_INPUT_OUTPUT
      FLOW_CHART_INTERNAL_STORAGE
      FLOW_CHART_MAGNETIC_DISK
      FLOW_CHART_MAGNETIC_DRUM
      FLOW_CHART_MAGNETIC_TAPE
      FLOW_CHART_MANUAL_INPUT
      FLOW_CHART_MANUAL_OPERATION
      FLOW_CHART_MERGE
      FLOW_CHART_MULTIDOCUMENT
      FLOW_CHART_OFFLINE_STORAGE
      FLOW_CHART_OFFPAGE_CONNECTOR
      FLOW_CHART_ONLINE_STORAGE
      FLOW_CHART_OR
      FLOW_CHART_PREDEFINED_PROCESS
      FLOW_CHART_PREPARATION
      FLOW_CHART_PROCESS
      FLOW_CHART_PUNCHED_CARD
      FLOW_CHART_PUNCHED_TAPE
      FLOW_CHART_SORT
      FLOW_CHART_SUMMING_JUNCTION
      FLOW_CHART_TERMINATOR
      ARROW_EAST
      ARROW_NORTH_EAST
      ARROW_NORTH
      SPEECH
      STARBURST
      TEARDROP
      ELLIPSE_RIBBON
      ELLIPSE_RIBBON_2
      CLOUD_CALLOUT
      CUSTOM],
     :text {:textElements [TextElement], :lists object},
     :shapeProperties
     {:shapeBackgroundFill ShapeBackgroundFill,
      :outline Outline,
      :shadow Shadow,
      :link Link,
      :contentAlignment
      [CONTENT_ALIGNMENT_UNSPECIFIED
       CONTENT_ALIGNMENT_UNSUPPORTED
       TOP
       MIDDLE
       BOTTOM],
      :autofit Autofit},
     :placeholder
     {:type
      [NONE
       BODY
       CHART
       CLIP_ART
       CENTERED_TITLE
       DIAGRAM
       DATE_AND_TIME
       FOOTER
       HEADER
       MEDIA
       OBJECT
       PICTURE
       SLIDE_NUMBER
       SUBTITLE
       TABLE
       TITLE
       SLIDE_IMAGE],
      :index integer,
      :parentObjectId string}},
    :wordArt {:renderedText string},
    :image
    {:contentUrl string,
     :imageProperties
     {:cropProperties CropProperties,
      :transparency number,
      :brightness number,
      :contrast number,
      :recolor Recolor,
      :outline Outline,
      :shadow Shadow,
      :link Link},
     :sourceUrl string,
     :placeholder
     {:type
      [NONE
       BODY
       CHART
       CLIP_ART
       CENTERED_TITLE
       DIAGRAM
       DATE_AND_TIME
       FOOTER
       HEADER
       MEDIA
       OBJECT
       PICTURE
       SLIDE_NUMBER
       SUBTITLE
       TABLE
       TITLE
       SLIDE_IMAGE],
      :index integer,
      :parentObjectId string}},
    :elementGroup
    {:children
     [{:description string,
       :video Video,
       :sheetsChart SheetsChart,
       :speakerSpotlight SpeakerSpotlight,
       :transform AffineTransform,
       :table Table,
       :objectId string,
       :size Size,
       :title string,
       :line Line,
       :shape Shape,
       :wordArt WordArt,
       :image Image,
       :elementGroup Group}]}}],
  :slideProperties
  {:layoutObjectId string,
   :masterObjectId string,
   :notesPage
   {:notesProperties {:speakerNotesObjectId string},
    :objectId string,
    :revisionId string,
    :pageElements
    [{:description string,
      :video Video,
      :sheetsChart SheetsChart,
      :speakerSpotlight SpeakerSpotlight,
      :transform AffineTransform,
      :table Table,
      :objectId string,
      :size Size,
      :title string,
      :line Line,
      :shape Shape,
      :wordArt WordArt,
      :image Image,
      :elementGroup Group}],
    :slideProperties
    {:layoutObjectId string,
     :masterObjectId string,
     :notesPage Page,
     :isSkipped boolean},
    :pageType [SLIDE MASTER LAYOUT NOTES NOTES_MASTER],
    :masterProperties {:displayName string},
    :layoutProperties
    {:masterObjectId string, :name string, :displayName string},
    :pageProperties
    {:pageBackgroundFill PageBackgroundFill,
     :colorScheme ColorScheme}},
   :isSkipped boolean},
  :pageType [SLIDE MASTER LAYOUT NOTES NOTES_MASTER],
  :masterProperties {:displayName string},
  :layoutProperties
  {:masterObjectId string, :name string, :displayName string},
  :pageProperties
  {:pageBackgroundFill
   {:propertyState [RENDERED NOT_RENDERED INHERIT],
    :solidFill {:color OpaqueColor, :alpha number},
    :stretchedPictureFill {:contentUrl string, :size Size}},
   :colorScheme
   {:colors
    [{:type
      [THEME_COLOR_TYPE_UNSPECIFIED
       DARK1
       LIGHT1
       DARK2
       LIGHT2
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       HYPERLINK
       FOLLOWED_HYPERLINK
       TEXT1
       BACKGROUND1
       TEXT2
       BACKGROUND2],
      :color RgbColor}]}}},
 :slides
 [{:notesProperties {:speakerNotesObjectId string},
   :objectId string,
   :revisionId string,
   :pageElements
   [{:description string,
     :video
     {:url string,
      :source [SOURCE_UNSPECIFIED YOUTUBE DRIVE],
      :id string,
      :videoProperties
      {:outline Outline,
       :autoPlay boolean,
       :start integer,
       :end integer,
       :mute boolean}},
     :sheetsChart
     {:spreadsheetId string,
      :chartId integer,
      :contentUrl string,
      :sheetsChartProperties {:chartImageProperties ImageProperties}},
     :speakerSpotlight
     {:speakerSpotlightProperties {:outline Outline, :shadow Shadow}},
     :transform
     {:scaleX number,
      :scaleY number,
      :shearX number,
      :shearY number,
      :translateX number,
      :translateY number,
      :unit [UNIT_UNSPECIFIED EMU PT]},
     :table
     {:rows integer,
      :columns integer,
      :tableRows
      [{:rowHeight Dimension,
        :tableRowProperties TableRowProperties,
        :tableCells [TableCell]}],
      :tableColumns [{:columnWidth Dimension}],
      :horizontalBorderRows [{:tableBorderCells [TableBorderCell]}],
      :verticalBorderRows [{:tableBorderCells [TableBorderCell]}]},
     :objectId string,
     :size
     {:width {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
      :height {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]}},
     :title string,
     :line
     {:lineProperties
      {:lineFill LineFill,
       :weight Dimension,
       :dashStyle
       [DASH_STYLE_UNSPECIFIED
        SOLID
        DOT
        DASH
        DASH_DOT
        LONG_DASH
        LONG_DASH_DOT],
       :startArrow
       [ARROW_STYLE_UNSPECIFIED
        NONE
        STEALTH_ARROW
        FILL_ARROW
        FILL_CIRCLE
        FILL_SQUARE
        FILL_DIAMOND
        OPEN_ARROW
        OPEN_CIRCLE
        OPEN_SQUARE
        OPEN_DIAMOND],
       :endArrow
       [ARROW_STYLE_UNSPECIFIED
        NONE
        STEALTH_ARROW
        FILL_ARROW
        FILL_CIRCLE
        FILL_SQUARE
        FILL_DIAMOND
        OPEN_ARROW
        OPEN_CIRCLE
        OPEN_SQUARE
        OPEN_DIAMOND],
       :link Link,
       :startConnection LineConnection,
       :endConnection LineConnection},
      :lineType
      [TYPE_UNSPECIFIED
       STRAIGHT_CONNECTOR_1
       BENT_CONNECTOR_2
       BENT_CONNECTOR_3
       BENT_CONNECTOR_4
       BENT_CONNECTOR_5
       CURVED_CONNECTOR_2
       CURVED_CONNECTOR_3
       CURVED_CONNECTOR_4
       CURVED_CONNECTOR_5
       STRAIGHT_LINE],
      :lineCategory [LINE_CATEGORY_UNSPECIFIED STRAIGHT BENT CURVED]},
     :shape
     {:shapeType
      [TYPE_UNSPECIFIED
       TEXT_BOX
       RECTANGLE
       ROUND_RECTANGLE
       ELLIPSE
       ARC
       BENT_ARROW
       BENT_UP_ARROW
       BEVEL
       BLOCK_ARC
       BRACE_PAIR
       BRACKET_PAIR
       CAN
       CHEVRON
       CHORD
       CLOUD
       CORNER
       CUBE
       CURVED_DOWN_ARROW
       CURVED_LEFT_ARROW
       CURVED_RIGHT_ARROW
       CURVED_UP_ARROW
       DECAGON
       DIAGONAL_STRIPE
       DIAMOND
       DODECAGON
       DONUT
       DOUBLE_WAVE
       DOWN_ARROW
       DOWN_ARROW_CALLOUT
       FOLDED_CORNER
       FRAME
       HALF_FRAME
       HEART
       HEPTAGON
       HEXAGON
       HOME_PLATE
       HORIZONTAL_SCROLL
       IRREGULAR_SEAL_1
       IRREGULAR_SEAL_2
       LEFT_ARROW
       LEFT_ARROW_CALLOUT
       LEFT_BRACE
       LEFT_BRACKET
       LEFT_RIGHT_ARROW
       LEFT_RIGHT_ARROW_CALLOUT
       LEFT_RIGHT_UP_ARROW
       LEFT_UP_ARROW
       LIGHTNING_BOLT
       MATH_DIVIDE
       MATH_EQUAL
       MATH_MINUS
       MATH_MULTIPLY
       MATH_NOT_EQUAL
       MATH_PLUS
       MOON
       NO_SMOKING
       NOTCHED_RIGHT_ARROW
       OCTAGON
       PARALLELOGRAM
       PENTAGON
       PIE
       PLAQUE
       PLUS
       QUAD_ARROW
       QUAD_ARROW_CALLOUT
       RIBBON
       RIBBON_2
       RIGHT_ARROW
       RIGHT_ARROW_CALLOUT
       RIGHT_BRACE
       RIGHT_BRACKET
       ROUND_1_RECTANGLE
       ROUND_2_DIAGONAL_RECTANGLE
       ROUND_2_SAME_RECTANGLE
       RIGHT_TRIANGLE
       SMILEY_FACE
       SNIP_1_RECTANGLE
       SNIP_2_DIAGONAL_RECTANGLE
       SNIP_2_SAME_RECTANGLE
       SNIP_ROUND_RECTANGLE
       STAR_10
       STAR_12
       STAR_16
       STAR_24
       STAR_32
       STAR_4
       STAR_5
       STAR_6
       STAR_7
       STAR_8
       STRIPED_RIGHT_ARROW
       SUN
       TRAPEZOID
       TRIANGLE
       UP_ARROW
       UP_ARROW_CALLOUT
       UP_DOWN_ARROW
       UTURN_ARROW
       VERTICAL_SCROLL
       WAVE
       WEDGE_ELLIPSE_CALLOUT
       WEDGE_RECTANGLE_CALLOUT
       WEDGE_ROUND_RECTANGLE_CALLOUT
       FLOW_CHART_ALTERNATE_PROCESS
       FLOW_CHART_COLLATE
       FLOW_CHART_CONNECTOR
       FLOW_CHART_DECISION
       FLOW_CHART_DELAY
       FLOW_CHART_DISPLAY
       FLOW_CHART_DOCUMENT
       FLOW_CHART_EXTRACT
       FLOW_CHART_INPUT_OUTPUT
       FLOW_CHART_INTERNAL_STORAGE
       FLOW_CHART_MAGNETIC_DISK
       FLOW_CHART_MAGNETIC_DRUM
       FLOW_CHART_MAGNETIC_TAPE
       FLOW_CHART_MANUAL_INPUT
       FLOW_CHART_MANUAL_OPERATION
       FLOW_CHART_MERGE
       FLOW_CHART_MULTIDOCUMENT
       FLOW_CHART_OFFLINE_STORAGE
       FLOW_CHART_OFFPAGE_CONNECTOR
       FLOW_CHART_ONLINE_STORAGE
       FLOW_CHART_OR
       FLOW_CHART_PREDEFINED_PROCESS
       FLOW_CHART_PREPARATION
       FLOW_CHART_PROCESS
       FLOW_CHART_PUNCHED_CARD
       FLOW_CHART_PUNCHED_TAPE
       FLOW_CHART_SORT
       FLOW_CHART_SUMMING_JUNCTION
       FLOW_CHART_TERMINATOR
       ARROW_EAST
       ARROW_NORTH_EAST
       ARROW_NORTH
       SPEECH
       STARBURST
       TEARDROP
       ELLIPSE_RIBBON
       ELLIPSE_RIBBON_2
       CLOUD_CALLOUT
       CUSTOM],
      :text {:textElements [TextElement], :lists object},
      :shapeProperties
      {:shapeBackgroundFill ShapeBackgroundFill,
       :outline Outline,
       :shadow Shadow,
       :link Link,
       :contentAlignment
       [CONTENT_ALIGNMENT_UNSPECIFIED
        CONTENT_ALIGNMENT_UNSUPPORTED
        TOP
        MIDDLE
        BOTTOM],
       :autofit Autofit},
      :placeholder
      {:type
       [NONE
        BODY
        CHART
        CLIP_ART
        CENTERED_TITLE
        DIAGRAM
        DATE_AND_TIME
        FOOTER
        HEADER
        MEDIA
        OBJECT
        PICTURE
        SLIDE_NUMBER
        SUBTITLE
        TABLE
        TITLE
        SLIDE_IMAGE],
       :index integer,
       :parentObjectId string}},
     :wordArt {:renderedText string},
     :image
     {:contentUrl string,
      :imageProperties
      {:cropProperties CropProperties,
       :transparency number,
       :brightness number,
       :contrast number,
       :recolor Recolor,
       :outline Outline,
       :shadow Shadow,
       :link Link},
      :sourceUrl string,
      :placeholder
      {:type
       [NONE
        BODY
        CHART
        CLIP_ART
        CENTERED_TITLE
        DIAGRAM
        DATE_AND_TIME
        FOOTER
        HEADER
        MEDIA
        OBJECT
        PICTURE
        SLIDE_NUMBER
        SUBTITLE
        TABLE
        TITLE
        SLIDE_IMAGE],
       :index integer,
       :parentObjectId string}},
     :elementGroup
     {:children
      [{:description string,
        :video Video,
        :sheetsChart SheetsChart,
        :speakerSpotlight SpeakerSpotlight,
        :transform AffineTransform,
        :table Table,
        :objectId string,
        :size Size,
        :title string,
        :line Line,
        :shape Shape,
        :wordArt WordArt,
        :image Image,
        :elementGroup Group}]}}],
   :slideProperties
   {:layoutObjectId string,
    :masterObjectId string,
    :notesPage
    {:notesProperties {:speakerNotesObjectId string},
     :objectId string,
     :revisionId string,
     :pageElements
     [{:description string,
       :video Video,
       :sheetsChart SheetsChart,
       :speakerSpotlight SpeakerSpotlight,
       :transform AffineTransform,
       :table Table,
       :objectId string,
       :size Size,
       :title string,
       :line Line,
       :shape Shape,
       :wordArt WordArt,
       :image Image,
       :elementGroup Group}],
     :slideProperties
     {:layoutObjectId string,
      :masterObjectId string,
      :notesPage Page,
      :isSkipped boolean},
     :pageType [SLIDE MASTER LAYOUT NOTES NOTES_MASTER],
     :masterProperties {:displayName string},
     :layoutProperties
     {:masterObjectId string, :name string, :displayName string},
     :pageProperties
     {:pageBackgroundFill PageBackgroundFill,
      :colorScheme ColorScheme}},
    :isSkipped boolean},
   :pageType [SLIDE MASTER LAYOUT NOTES NOTES_MASTER],
   :masterProperties {:displayName string},
   :layoutProperties
   {:masterObjectId string, :name string, :displayName string},
   :pageProperties
   {:pageBackgroundFill
    {:propertyState [RENDERED NOT_RENDERED INHERIT],
     :solidFill {:color OpaqueColor, :alpha number},
     :stretchedPictureFill {:contentUrl string, :size Size}},
    :colorScheme
    {:colors
     [{:type
       [THEME_COLOR_TYPE_UNSPECIFIED
        DARK1
        LIGHT1
        DARK2
        LIGHT2
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        HYPERLINK
        FOLLOWED_HYPERLINK
        TEXT1
        BACKGROUND1
        TEXT2
        BACKGROUND2],
       :color RgbColor}]}}}],
 :revisionId string,
 :title string,
 :layouts
 [{:notesProperties {:speakerNotesObjectId string},
   :objectId string,
   :revisionId string,
   :pageElements
   [{:description string,
     :video
     {:url string,
      :source [SOURCE_UNSPECIFIED YOUTUBE DRIVE],
      :id string,
      :videoProperties
      {:outline Outline,
       :autoPlay boolean,
       :start integer,
       :end integer,
       :mute boolean}},
     :sheetsChart
     {:spreadsheetId string,
      :chartId integer,
      :contentUrl string,
      :sheetsChartProperties {:chartImageProperties ImageProperties}},
     :speakerSpotlight
     {:speakerSpotlightProperties {:outline Outline, :shadow Shadow}},
     :transform
     {:scaleX number,
      :scaleY number,
      :shearX number,
      :shearY number,
      :translateX number,
      :translateY number,
      :unit [UNIT_UNSPECIFIED EMU PT]},
     :table
     {:rows integer,
      :columns integer,
      :tableRows
      [{:rowHeight Dimension,
        :tableRowProperties TableRowProperties,
        :tableCells [TableCell]}],
      :tableColumns [{:columnWidth Dimension}],
      :horizontalBorderRows [{:tableBorderCells [TableBorderCell]}],
      :verticalBorderRows [{:tableBorderCells [TableBorderCell]}]},
     :objectId string,
     :size
     {:width {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
      :height {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]}},
     :title string,
     :line
     {:lineProperties
      {:lineFill LineFill,
       :weight Dimension,
       :dashStyle
       [DASH_STYLE_UNSPECIFIED
        SOLID
        DOT
        DASH
        DASH_DOT
        LONG_DASH
        LONG_DASH_DOT],
       :startArrow
       [ARROW_STYLE_UNSPECIFIED
        NONE
        STEALTH_ARROW
        FILL_ARROW
        FILL_CIRCLE
        FILL_SQUARE
        FILL_DIAMOND
        OPEN_ARROW
        OPEN_CIRCLE
        OPEN_SQUARE
        OPEN_DIAMOND],
       :endArrow
       [ARROW_STYLE_UNSPECIFIED
        NONE
        STEALTH_ARROW
        FILL_ARROW
        FILL_CIRCLE
        FILL_SQUARE
        FILL_DIAMOND
        OPEN_ARROW
        OPEN_CIRCLE
        OPEN_SQUARE
        OPEN_DIAMOND],
       :link Link,
       :startConnection LineConnection,
       :endConnection LineConnection},
      :lineType
      [TYPE_UNSPECIFIED
       STRAIGHT_CONNECTOR_1
       BENT_CONNECTOR_2
       BENT_CONNECTOR_3
       BENT_CONNECTOR_4
       BENT_CONNECTOR_5
       CURVED_CONNECTOR_2
       CURVED_CONNECTOR_3
       CURVED_CONNECTOR_4
       CURVED_CONNECTOR_5
       STRAIGHT_LINE],
      :lineCategory [LINE_CATEGORY_UNSPECIFIED STRAIGHT BENT CURVED]},
     :shape
     {:shapeType
      [TYPE_UNSPECIFIED
       TEXT_BOX
       RECTANGLE
       ROUND_RECTANGLE
       ELLIPSE
       ARC
       BENT_ARROW
       BENT_UP_ARROW
       BEVEL
       BLOCK_ARC
       BRACE_PAIR
       BRACKET_PAIR
       CAN
       CHEVRON
       CHORD
       CLOUD
       CORNER
       CUBE
       CURVED_DOWN_ARROW
       CURVED_LEFT_ARROW
       CURVED_RIGHT_ARROW
       CURVED_UP_ARROW
       DECAGON
       DIAGONAL_STRIPE
       DIAMOND
       DODECAGON
       DONUT
       DOUBLE_WAVE
       DOWN_ARROW
       DOWN_ARROW_CALLOUT
       FOLDED_CORNER
       FRAME
       HALF_FRAME
       HEART
       HEPTAGON
       HEXAGON
       HOME_PLATE
       HORIZONTAL_SCROLL
       IRREGULAR_SEAL_1
       IRREGULAR_SEAL_2
       LEFT_ARROW
       LEFT_ARROW_CALLOUT
       LEFT_BRACE
       LEFT_BRACKET
       LEFT_RIGHT_ARROW
       LEFT_RIGHT_ARROW_CALLOUT
       LEFT_RIGHT_UP_ARROW
       LEFT_UP_ARROW
       LIGHTNING_BOLT
       MATH_DIVIDE
       MATH_EQUAL
       MATH_MINUS
       MATH_MULTIPLY
       MATH_NOT_EQUAL
       MATH_PLUS
       MOON
       NO_SMOKING
       NOTCHED_RIGHT_ARROW
       OCTAGON
       PARALLELOGRAM
       PENTAGON
       PIE
       PLAQUE
       PLUS
       QUAD_ARROW
       QUAD_ARROW_CALLOUT
       RIBBON
       RIBBON_2
       RIGHT_ARROW
       RIGHT_ARROW_CALLOUT
       RIGHT_BRACE
       RIGHT_BRACKET
       ROUND_1_RECTANGLE
       ROUND_2_DIAGONAL_RECTANGLE
       ROUND_2_SAME_RECTANGLE
       RIGHT_TRIANGLE
       SMILEY_FACE
       SNIP_1_RECTANGLE
       SNIP_2_DIAGONAL_RECTANGLE
       SNIP_2_SAME_RECTANGLE
       SNIP_ROUND_RECTANGLE
       STAR_10
       STAR_12
       STAR_16
       STAR_24
       STAR_32
       STAR_4
       STAR_5
       STAR_6
       STAR_7
       STAR_8
       STRIPED_RIGHT_ARROW
       SUN
       TRAPEZOID
       TRIANGLE
       UP_ARROW
       UP_ARROW_CALLOUT
       UP_DOWN_ARROW
       UTURN_ARROW
       VERTICAL_SCROLL
       WAVE
       WEDGE_ELLIPSE_CALLOUT
       WEDGE_RECTANGLE_CALLOUT
       WEDGE_ROUND_RECTANGLE_CALLOUT
       FLOW_CHART_ALTERNATE_PROCESS
       FLOW_CHART_COLLATE
       FLOW_CHART_CONNECTOR
       FLOW_CHART_DECISION
       FLOW_CHART_DELAY
       FLOW_CHART_DISPLAY
       FLOW_CHART_DOCUMENT
       FLOW_CHART_EXTRACT
       FLOW_CHART_INPUT_OUTPUT
       FLOW_CHART_INTERNAL_STORAGE
       FLOW_CHART_MAGNETIC_DISK
       FLOW_CHART_MAGNETIC_DRUM
       FLOW_CHART_MAGNETIC_TAPE
       FLOW_CHART_MANUAL_INPUT
       FLOW_CHART_MANUAL_OPERATION
       FLOW_CHART_MERGE
       FLOW_CHART_MULTIDOCUMENT
       FLOW_CHART_OFFLINE_STORAGE
       FLOW_CHART_OFFPAGE_CONNECTOR
       FLOW_CHART_ONLINE_STORAGE
       FLOW_CHART_OR
       FLOW_CHART_PREDEFINED_PROCESS
       FLOW_CHART_PREPARATION
       FLOW_CHART_PROCESS
       FLOW_CHART_PUNCHED_CARD
       FLOW_CHART_PUNCHED_TAPE
       FLOW_CHART_SORT
       FLOW_CHART_SUMMING_JUNCTION
       FLOW_CHART_TERMINATOR
       ARROW_EAST
       ARROW_NORTH_EAST
       ARROW_NORTH
       SPEECH
       STARBURST
       TEARDROP
       ELLIPSE_RIBBON
       ELLIPSE_RIBBON_2
       CLOUD_CALLOUT
       CUSTOM],
      :text {:textElements [TextElement], :lists object},
      :shapeProperties
      {:shapeBackgroundFill ShapeBackgroundFill,
       :outline Outline,
       :shadow Shadow,
       :link Link,
       :contentAlignment
       [CONTENT_ALIGNMENT_UNSPECIFIED
        CONTENT_ALIGNMENT_UNSUPPORTED
        TOP
        MIDDLE
        BOTTOM],
       :autofit Autofit},
      :placeholder
      {:type
       [NONE
        BODY
        CHART
        CLIP_ART
        CENTERED_TITLE
        DIAGRAM
        DATE_AND_TIME
        FOOTER
        HEADER
        MEDIA
        OBJECT
        PICTURE
        SLIDE_NUMBER
        SUBTITLE
        TABLE
        TITLE
        SLIDE_IMAGE],
       :index integer,
       :parentObjectId string}},
     :wordArt {:renderedText string},
     :image
     {:contentUrl string,
      :imageProperties
      {:cropProperties CropProperties,
       :transparency number,
       :brightness number,
       :contrast number,
       :recolor Recolor,
       :outline Outline,
       :shadow Shadow,
       :link Link},
      :sourceUrl string,
      :placeholder
      {:type
       [NONE
        BODY
        CHART
        CLIP_ART
        CENTERED_TITLE
        DIAGRAM
        DATE_AND_TIME
        FOOTER
        HEADER
        MEDIA
        OBJECT
        PICTURE
        SLIDE_NUMBER
        SUBTITLE
        TABLE
        TITLE
        SLIDE_IMAGE],
       :index integer,
       :parentObjectId string}},
     :elementGroup
     {:children
      [{:description string,
        :video Video,
        :sheetsChart SheetsChart,
        :speakerSpotlight SpeakerSpotlight,
        :transform AffineTransform,
        :table Table,
        :objectId string,
        :size Size,
        :title string,
        :line Line,
        :shape Shape,
        :wordArt WordArt,
        :image Image,
        :elementGroup Group}]}}],
   :slideProperties
   {:layoutObjectId string,
    :masterObjectId string,
    :notesPage
    {:notesProperties {:speakerNotesObjectId string},
     :objectId string,
     :revisionId string,
     :pageElements
     [{:description string,
       :video Video,
       :sheetsChart SheetsChart,
       :speakerSpotlight SpeakerSpotlight,
       :transform AffineTransform,
       :table Table,
       :objectId string,
       :size Size,
       :title string,
       :line Line,
       :shape Shape,
       :wordArt WordArt,
       :image Image,
       :elementGroup Group}],
     :slideProperties
     {:layoutObjectId string,
      :masterObjectId string,
      :notesPage Page,
      :isSkipped boolean},
     :pageType [SLIDE MASTER LAYOUT NOTES NOTES_MASTER],
     :masterProperties {:displayName string},
     :layoutProperties
     {:masterObjectId string, :name string, :displayName string},
     :pageProperties
     {:pageBackgroundFill PageBackgroundFill,
      :colorScheme ColorScheme}},
    :isSkipped boolean},
   :pageType [SLIDE MASTER LAYOUT NOTES NOTES_MASTER],
   :masterProperties {:displayName string},
   :layoutProperties
   {:masterObjectId string, :name string, :displayName string},
   :pageProperties
   {:pageBackgroundFill
    {:propertyState [RENDERED NOT_RENDERED INHERIT],
     :solidFill {:color OpaqueColor, :alpha number},
     :stretchedPictureFill {:contentUrl string, :size Size}},
    :colorScheme
    {:colors
     [{:type
       [THEME_COLOR_TYPE_UNSPECIFIED
        DARK1
        LIGHT1
        DARK2
        LIGHT2
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        HYPERLINK
        FOLLOWED_HYPERLINK
        TEXT1
        BACKGROUND1
        TEXT2
        BACKGROUND2],
       :color RgbColor}]}}}],
 :pageSize
 {:width {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
  :height {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]}},
 :masters
 [{:notesProperties {:speakerNotesObjectId string},
   :objectId string,
   :revisionId string,
   :pageElements
   [{:description string,
     :video
     {:url string,
      :source [SOURCE_UNSPECIFIED YOUTUBE DRIVE],
      :id string,
      :videoProperties
      {:outline Outline,
       :autoPlay boolean,
       :start integer,
       :end integer,
       :mute boolean}},
     :sheetsChart
     {:spreadsheetId string,
      :chartId integer,
      :contentUrl string,
      :sheetsChartProperties {:chartImageProperties ImageProperties}},
     :speakerSpotlight
     {:speakerSpotlightProperties {:outline Outline, :shadow Shadow}},
     :transform
     {:scaleX number,
      :scaleY number,
      :shearX number,
      :shearY number,
      :translateX number,
      :translateY number,
      :unit [UNIT_UNSPECIFIED EMU PT]},
     :table
     {:rows integer,
      :columns integer,
      :tableRows
      [{:rowHeight Dimension,
        :tableRowProperties TableRowProperties,
        :tableCells [TableCell]}],
      :tableColumns [{:columnWidth Dimension}],
      :horizontalBorderRows [{:tableBorderCells [TableBorderCell]}],
      :verticalBorderRows [{:tableBorderCells [TableBorderCell]}]},
     :objectId string,
     :size
     {:width {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
      :height {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]}},
     :title string,
     :line
     {:lineProperties
      {:lineFill LineFill,
       :weight Dimension,
       :dashStyle
       [DASH_STYLE_UNSPECIFIED
        SOLID
        DOT
        DASH
        DASH_DOT
        LONG_DASH
        LONG_DASH_DOT],
       :startArrow
       [ARROW_STYLE_UNSPECIFIED
        NONE
        STEALTH_ARROW
        FILL_ARROW
        FILL_CIRCLE
        FILL_SQUARE
        FILL_DIAMOND
        OPEN_ARROW
        OPEN_CIRCLE
        OPEN_SQUARE
        OPEN_DIAMOND],
       :endArrow
       [ARROW_STYLE_UNSPECIFIED
        NONE
        STEALTH_ARROW
        FILL_ARROW
        FILL_CIRCLE
        FILL_SQUARE
        FILL_DIAMOND
        OPEN_ARROW
        OPEN_CIRCLE
        OPEN_SQUARE
        OPEN_DIAMOND],
       :link Link,
       :startConnection LineConnection,
       :endConnection LineConnection},
      :lineType
      [TYPE_UNSPECIFIED
       STRAIGHT_CONNECTOR_1
       BENT_CONNECTOR_2
       BENT_CONNECTOR_3
       BENT_CONNECTOR_4
       BENT_CONNECTOR_5
       CURVED_CONNECTOR_2
       CURVED_CONNECTOR_3
       CURVED_CONNECTOR_4
       CURVED_CONNECTOR_5
       STRAIGHT_LINE],
      :lineCategory [LINE_CATEGORY_UNSPECIFIED STRAIGHT BENT CURVED]},
     :shape
     {:shapeType
      [TYPE_UNSPECIFIED
       TEXT_BOX
       RECTANGLE
       ROUND_RECTANGLE
       ELLIPSE
       ARC
       BENT_ARROW
       BENT_UP_ARROW
       BEVEL
       BLOCK_ARC
       BRACE_PAIR
       BRACKET_PAIR
       CAN
       CHEVRON
       CHORD
       CLOUD
       CORNER
       CUBE
       CURVED_DOWN_ARROW
       CURVED_LEFT_ARROW
       CURVED_RIGHT_ARROW
       CURVED_UP_ARROW
       DECAGON
       DIAGONAL_STRIPE
       DIAMOND
       DODECAGON
       DONUT
       DOUBLE_WAVE
       DOWN_ARROW
       DOWN_ARROW_CALLOUT
       FOLDED_CORNER
       FRAME
       HALF_FRAME
       HEART
       HEPTAGON
       HEXAGON
       HOME_PLATE
       HORIZONTAL_SCROLL
       IRREGULAR_SEAL_1
       IRREGULAR_SEAL_2
       LEFT_ARROW
       LEFT_ARROW_CALLOUT
       LEFT_BRACE
       LEFT_BRACKET
       LEFT_RIGHT_ARROW
       LEFT_RIGHT_ARROW_CALLOUT
       LEFT_RIGHT_UP_ARROW
       LEFT_UP_ARROW
       LIGHTNING_BOLT
       MATH_DIVIDE
       MATH_EQUAL
       MATH_MINUS
       MATH_MULTIPLY
       MATH_NOT_EQUAL
       MATH_PLUS
       MOON
       NO_SMOKING
       NOTCHED_RIGHT_ARROW
       OCTAGON
       PARALLELOGRAM
       PENTAGON
       PIE
       PLAQUE
       PLUS
       QUAD_ARROW
       QUAD_ARROW_CALLOUT
       RIBBON
       RIBBON_2
       RIGHT_ARROW
       RIGHT_ARROW_CALLOUT
       RIGHT_BRACE
       RIGHT_BRACKET
       ROUND_1_RECTANGLE
       ROUND_2_DIAGONAL_RECTANGLE
       ROUND_2_SAME_RECTANGLE
       RIGHT_TRIANGLE
       SMILEY_FACE
       SNIP_1_RECTANGLE
       SNIP_2_DIAGONAL_RECTANGLE
       SNIP_2_SAME_RECTANGLE
       SNIP_ROUND_RECTANGLE
       STAR_10
       STAR_12
       STAR_16
       STAR_24
       STAR_32
       STAR_4
       STAR_5
       STAR_6
       STAR_7
       STAR_8
       STRIPED_RIGHT_ARROW
       SUN
       TRAPEZOID
       TRIANGLE
       UP_ARROW
       UP_ARROW_CALLOUT
       UP_DOWN_ARROW
       UTURN_ARROW
       VERTICAL_SCROLL
       WAVE
       WEDGE_ELLIPSE_CALLOUT
       WEDGE_RECTANGLE_CALLOUT
       WEDGE_ROUND_RECTANGLE_CALLOUT
       FLOW_CHART_ALTERNATE_PROCESS
       FLOW_CHART_COLLATE
       FLOW_CHART_CONNECTOR
       FLOW_CHART_DECISION
       FLOW_CHART_DELAY
       FLOW_CHART_DISPLAY
       FLOW_CHART_DOCUMENT
       FLOW_CHART_EXTRACT
       FLOW_CHART_INPUT_OUTPUT
       FLOW_CHART_INTERNAL_STORAGE
       FLOW_CHART_MAGNETIC_DISK
       FLOW_CHART_MAGNETIC_DRUM
       FLOW_CHART_MAGNETIC_TAPE
       FLOW_CHART_MANUAL_INPUT
       FLOW_CHART_MANUAL_OPERATION
       FLOW_CHART_MERGE
       FLOW_CHART_MULTIDOCUMENT
       FLOW_CHART_OFFLINE_STORAGE
       FLOW_CHART_OFFPAGE_CONNECTOR
       FLOW_CHART_ONLINE_STORAGE
       FLOW_CHART_OR
       FLOW_CHART_PREDEFINED_PROCESS
       FLOW_CHART_PREPARATION
       FLOW_CHART_PROCESS
       FLOW_CHART_PUNCHED_CARD
       FLOW_CHART_PUNCHED_TAPE
       FLOW_CHART_SORT
       FLOW_CHART_SUMMING_JUNCTION
       FLOW_CHART_TERMINATOR
       ARROW_EAST
       ARROW_NORTH_EAST
       ARROW_NORTH
       SPEECH
       STARBURST
       TEARDROP
       ELLIPSE_RIBBON
       ELLIPSE_RIBBON_2
       CLOUD_CALLOUT
       CUSTOM],
      :text {:textElements [TextElement], :lists object},
      :shapeProperties
      {:shapeBackgroundFill ShapeBackgroundFill,
       :outline Outline,
       :shadow Shadow,
       :link Link,
       :contentAlignment
       [CONTENT_ALIGNMENT_UNSPECIFIED
        CONTENT_ALIGNMENT_UNSUPPORTED
        TOP
        MIDDLE
        BOTTOM],
       :autofit Autofit},
      :placeholder
      {:type
       [NONE
        BODY
        CHART
        CLIP_ART
        CENTERED_TITLE
        DIAGRAM
        DATE_AND_TIME
        FOOTER
        HEADER
        MEDIA
        OBJECT
        PICTURE
        SLIDE_NUMBER
        SUBTITLE
        TABLE
        TITLE
        SLIDE_IMAGE],
       :index integer,
       :parentObjectId string}},
     :wordArt {:renderedText string},
     :image
     {:contentUrl string,
      :imageProperties
      {:cropProperties CropProperties,
       :transparency number,
       :brightness number,
       :contrast number,
       :recolor Recolor,
       :outline Outline,
       :shadow Shadow,
       :link Link},
      :sourceUrl string,
      :placeholder
      {:type
       [NONE
        BODY
        CHART
        CLIP_ART
        CENTERED_TITLE
        DIAGRAM
        DATE_AND_TIME
        FOOTER
        HEADER
        MEDIA
        OBJECT
        PICTURE
        SLIDE_NUMBER
        SUBTITLE
        TABLE
        TITLE
        SLIDE_IMAGE],
       :index integer,
       :parentObjectId string}},
     :elementGroup
     {:children
      [{:description string,
        :video Video,
        :sheetsChart SheetsChart,
        :speakerSpotlight SpeakerSpotlight,
        :transform AffineTransform,
        :table Table,
        :objectId string,
        :size Size,
        :title string,
        :line Line,
        :shape Shape,
        :wordArt WordArt,
        :image Image,
        :elementGroup Group}]}}],
   :slideProperties
   {:layoutObjectId string,
    :masterObjectId string,
    :notesPage
    {:notesProperties {:speakerNotesObjectId string},
     :objectId string,
     :revisionId string,
     :pageElements
     [{:description string,
       :video Video,
       :sheetsChart SheetsChart,
       :speakerSpotlight SpeakerSpotlight,
       :transform AffineTransform,
       :table Table,
       :objectId string,
       :size Size,
       :title string,
       :line Line,
       :shape Shape,
       :wordArt WordArt,
       :image Image,
       :elementGroup Group}],
     :slideProperties
     {:layoutObjectId string,
      :masterObjectId string,
      :notesPage Page,
      :isSkipped boolean},
     :pageType [SLIDE MASTER LAYOUT NOTES NOTES_MASTER],
     :masterProperties {:displayName string},
     :layoutProperties
     {:masterObjectId string, :name string, :displayName string},
     :pageProperties
     {:pageBackgroundFill PageBackgroundFill,
      :colorScheme ColorScheme}},
    :isSkipped boolean},
   :pageType [SLIDE MASTER LAYOUT NOTES NOTES_MASTER],
   :masterProperties {:displayName string},
   :layoutProperties
   {:masterObjectId string, :name string, :displayName string},
   :pageProperties
   {:pageBackgroundFill
    {:propertyState [RENDERED NOT_RENDERED INHERIT],
     :solidFill {:color OpaqueColor, :alpha number},
     :stretchedPictureFill {:contentUrl string, :size Size}},
    :colorScheme
    {:colors
     [{:type
       [THEME_COLOR_TYPE_UNSPECIFIED
        DARK1
        LIGHT1
        DARK2
        LIGHT2
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        HYPERLINK
        FOLLOWED_HYPERLINK
        TEXT1
        BACKGROUND1
        TEXT2
        BACKGROUND2],
       :color RgbColor}]}}}],
 :presentationId string}"
  [Presentation]
  (client/api-request
    {:method "POST",
     :uri-template "https://slides.googleapis.com/v1/presentations",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/presentations"],
     :body Presentation}))

(defn presentations-batchUpdate
  "Applies one or more updates to the presentation. Each request is validated before being applied. If any request is not valid, then the entire request will fail and nothing will be applied. Some requests have replies to give you some information about how they are applied. Other requests do not need to return information; these each return an empty reply. The order of replies matches that of the requests. For example, suppose you call batchUpdate with four updates, and only the third one returns information. The response would have two empty replies: the reply to the third request, and another empty reply, in that order. Because other users may be editing the presentation, the presentation might not exactly reflect your changes: your changes may be altered with respect to collaborator changes. If there are no collaborators, the presentation should reflect your changes. In any case, the updates in your request are guaranteed to be applied together atomically.
https://developers.google.com/slides/reference/rest/v1/presentations/batchUpdate

presentationId <string> The presentation to apply the updates to.
BatchUpdatePresentationRequest:
{:requests
 [{:updateImageProperties
   {:objectId string,
    :imageProperties
    {:cropProperties
     {:leftOffset number,
      :rightOffset number,
      :topOffset number,
      :bottomOffset number,
      :angle number},
     :transparency number,
     :brightness number,
     :contrast number,
     :recolor
     {:recolorStops [ColorStop],
      :name
      [NONE
       LIGHT1
       LIGHT2
       LIGHT3
       LIGHT4
       LIGHT5
       LIGHT6
       LIGHT7
       LIGHT8
       LIGHT9
       LIGHT10
       DARK1
       DARK2
       DARK3
       DARK4
       DARK5
       DARK6
       DARK7
       DARK8
       DARK9
       DARK10
       GRAYSCALE
       NEGATIVE
       SEPIA
       CUSTOM]},
     :outline
     {:outlineFill OutlineFill,
      :weight Dimension,
      :dashStyle
      [DASH_STYLE_UNSPECIFIED
       SOLID
       DOT
       DASH
       DASH_DOT
       LONG_DASH
       LONG_DASH_DOT],
      :propertyState [RENDERED NOT_RENDERED INHERIT]},
     :shadow
     {:type [SHADOW_TYPE_UNSPECIFIED OUTER],
      :transform AffineTransform,
      :alignment
      [RECTANGLE_POSITION_UNSPECIFIED
       TOP_LEFT
       TOP_CENTER
       TOP_RIGHT
       LEFT_CENTER
       CENTER
       RIGHT_CENTER
       BOTTOM_LEFT
       BOTTOM_CENTER
       BOTTOM_RIGHT],
      :blurRadius Dimension,
      :color OpaqueColor,
      :alpha number,
      :rotateWithShape boolean,
      :propertyState [RENDERED NOT_RENDERED INHERIT]},
     :link
     {:url string,
      :relativeLink
      [RELATIVE_SLIDE_LINK_UNSPECIFIED
       NEXT_SLIDE
       PREVIOUS_SLIDE
       FIRST_SLIDE
       LAST_SLIDE],
      :pageObjectId string,
      :slideIndex integer}},
    :fields string},
   :updatePageElementsZOrder
   {:pageElementObjectIds [string],
    :operation
    [Z_ORDER_OPERATION_UNSPECIFIED
     BRING_TO_FRONT
     BRING_FORWARD
     SEND_BACKWARD
     SEND_TO_BACK]},
   :updatePageElementTransform
   {:objectId string,
    :transform
    {:scaleX number,
     :scaleY number,
     :shearX number,
     :shearY number,
     :translateX number,
     :translateY number,
     :unit [UNIT_UNSPECIFIED EMU PT]},
    :applyMode [APPLY_MODE_UNSPECIFIED RELATIVE ABSOLUTE]},
   :createLine
   {:objectId string,
    :elementProperties
    {:pageObjectId string,
     :size {:width Dimension, :height Dimension},
     :transform
     {:scaleX number,
      :scaleY number,
      :shearX number,
      :shearY number,
      :translateX number,
      :translateY number,
      :unit [UNIT_UNSPECIFIED EMU PT]}},
    :lineCategory [STRAIGHT BENT CURVED],
    :category [LINE_CATEGORY_UNSPECIFIED STRAIGHT BENT CURVED]},
   :updateSlideProperties
   {:objectId string,
    :slideProperties
    {:layoutObjectId string,
     :masterObjectId string,
     :notesPage
     {:notesProperties NotesProperties,
      :objectId string,
      :revisionId string,
      :pageElements [PageElement],
      :slideProperties SlideProperties,
      :pageType [SLIDE MASTER LAYOUT NOTES NOTES_MASTER],
      :masterProperties MasterProperties,
      :layoutProperties LayoutProperties,
      :pageProperties PageProperties},
     :isSkipped boolean},
    :fields string},
   :createImage
   {:objectId string,
    :elementProperties
    {:pageObjectId string,
     :size {:width Dimension, :height Dimension},
     :transform
     {:scaleX number,
      :scaleY number,
      :shearX number,
      :shearY number,
      :translateX number,
      :translateY number,
      :unit [UNIT_UNSPECIFIED EMU PT]}},
    :url string},
   :deleteText
   {:objectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer},
    :textRange
    {:startIndex integer,
     :endIndex integer,
     :type [RANGE_TYPE_UNSPECIFIED FIXED_RANGE FROM_START_INDEX ALL]}},
   :createSheetsChart
   {:objectId string,
    :elementProperties
    {:pageObjectId string,
     :size {:width Dimension, :height Dimension},
     :transform
     {:scaleX number,
      :scaleY number,
      :shearX number,
      :shearY number,
      :translateX number,
      :translateY number,
      :unit [UNIT_UNSPECIFIED EMU PT]}},
    :spreadsheetId string,
    :chartId integer,
    :linkingMode [NOT_LINKED_IMAGE LINKED]},
   :replaceAllShapesWithImage
   {:containsText {:text string, :matchCase boolean},
    :imageUrl string,
    :replaceMethod [CENTER_INSIDE CENTER_CROP],
    :imageReplaceMethod
    [IMAGE_REPLACE_METHOD_UNSPECIFIED CENTER_INSIDE CENTER_CROP],
    :pageObjectIds [string]},
   :updatePageElementAltText
   {:objectId string, :title string, :description string},
   :duplicateObject {:objectId string, :objectIds object},
   :rerouteLine {:objectId string},
   :deleteTableRow
   {:tableObjectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer}},
   :createVideo
   {:objectId string,
    :elementProperties
    {:pageObjectId string,
     :size {:width Dimension, :height Dimension},
     :transform
     {:scaleX number,
      :scaleY number,
      :shearX number,
      :shearY number,
      :translateX number,
      :translateY number,
      :unit [UNIT_UNSPECIFIED EMU PT]}},
    :source [SOURCE_UNSPECIFIED YOUTUBE DRIVE],
    :id string},
   :replaceAllShapesWithSheetsChart
   {:containsText {:text string, :matchCase boolean},
    :spreadsheetId string,
    :chartId integer,
    :linkingMode [NOT_LINKED_IMAGE LINKED],
    :pageObjectIds [string]},
   :insertTableRows
   {:tableObjectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer},
    :insertBelow boolean,
    :number integer},
   :updateTextStyle
   {:objectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer},
    :style
    {:bold boolean,
     :smallCaps boolean,
     :baselineOffset
     [BASELINE_OFFSET_UNSPECIFIED NONE SUPERSCRIPT SUBSCRIPT],
     :underline boolean,
     :fontFamily string,
     :link
     {:url string,
      :relativeLink
      [RELATIVE_SLIDE_LINK_UNSPECIFIED
       NEXT_SLIDE
       PREVIOUS_SLIDE
       FIRST_SLIDE
       LAST_SLIDE],
      :pageObjectId string,
      :slideIndex integer},
     :strikethrough boolean,
     :fontSize {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
     :backgroundColor {:opaqueColor OpaqueColor},
     :italic boolean,
     :foregroundColor {:opaqueColor OpaqueColor},
     :weightedFontFamily {:fontFamily string, :weight integer}},
    :textRange
    {:startIndex integer,
     :endIndex integer,
     :type [RANGE_TYPE_UNSPECIFIED FIXED_RANGE FROM_START_INDEX ALL]},
    :fields string},
   :replaceAllText
   {:replaceText string,
    :pageObjectIds [string],
    :containsText {:text string, :matchCase boolean}},
   :updateLineCategory
   {:objectId string,
    :lineCategory [LINE_CATEGORY_UNSPECIFIED STRAIGHT BENT CURVED]},
   :refreshSheetsChart {:objectId string},
   :mergeTableCells
   {:objectId string,
    :tableRange
    {:location {:rowIndex integer, :columnIndex integer},
     :rowSpan integer,
     :columnSpan integer}},
   :updateTableColumnProperties
   {:objectId string,
    :columnIndices [integer],
    :tableColumnProperties
    {:columnWidth
     {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]}},
    :fields string},
   :updateTableRowProperties
   {:objectId string,
    :rowIndices [integer],
    :tableRowProperties
    {:minRowHeight
     {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]}},
    :fields string},
   :updateParagraphStyle
   {:objectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer},
    :style
    {:indentStart {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
     :spacingMode
     [SPACING_MODE_UNSPECIFIED NEVER_COLLAPSE COLLAPSE_LISTS],
     :alignment [ALIGNMENT_UNSPECIFIED START CENTER END JUSTIFIED],
     :indentFirstLine
     {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
     :indentEnd {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
     :spaceAbove {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
     :lineSpacing number,
     :spaceBelow {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
     :direction
     [TEXT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT]},
    :textRange
    {:startIndex integer,
     :endIndex integer,
     :type [RANGE_TYPE_UNSPECIFIED FIXED_RANGE FROM_START_INDEX ALL]},
    :fields string},
   :replaceImage
   {:imageObjectId string,
    :url string,
    :imageReplaceMethod
    [IMAGE_REPLACE_METHOD_UNSPECIFIED CENTER_INSIDE CENTER_CROP]},
   :updateShapeProperties
   {:objectId string,
    :shapeProperties
    {:shapeBackgroundFill
     {:propertyState [RENDERED NOT_RENDERED INHERIT],
      :solidFill SolidFill},
     :outline
     {:outlineFill OutlineFill,
      :weight Dimension,
      :dashStyle
      [DASH_STYLE_UNSPECIFIED
       SOLID
       DOT
       DASH
       DASH_DOT
       LONG_DASH
       LONG_DASH_DOT],
      :propertyState [RENDERED NOT_RENDERED INHERIT]},
     :shadow
     {:type [SHADOW_TYPE_UNSPECIFIED OUTER],
      :transform AffineTransform,
      :alignment
      [RECTANGLE_POSITION_UNSPECIFIED
       TOP_LEFT
       TOP_CENTER
       TOP_RIGHT
       LEFT_CENTER
       CENTER
       RIGHT_CENTER
       BOTTOM_LEFT
       BOTTOM_CENTER
       BOTTOM_RIGHT],
      :blurRadius Dimension,
      :color OpaqueColor,
      :alpha number,
      :rotateWithShape boolean,
      :propertyState [RENDERED NOT_RENDERED INHERIT]},
     :link
     {:url string,
      :relativeLink
      [RELATIVE_SLIDE_LINK_UNSPECIFIED
       NEXT_SLIDE
       PREVIOUS_SLIDE
       FIRST_SLIDE
       LAST_SLIDE],
      :pageObjectId string,
      :slideIndex integer},
     :contentAlignment
     [CONTENT_ALIGNMENT_UNSPECIFIED
      CONTENT_ALIGNMENT_UNSUPPORTED
      TOP
      MIDDLE
      BOTTOM],
     :autofit
     {:autofitType
      [AUTOFIT_TYPE_UNSPECIFIED NONE TEXT_AUTOFIT SHAPE_AUTOFIT],
      :fontScale number,
      :lineSpacingReduction number}},
    :fields string},
   :groupObjects {:groupObjectId string, :childrenObjectIds [string]},
   :updateLineProperties
   {:objectId string,
    :lineProperties
    {:lineFill {:solidFill SolidFill},
     :weight {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
     :dashStyle
     [DASH_STYLE_UNSPECIFIED
      SOLID
      DOT
      DASH
      DASH_DOT
      LONG_DASH
      LONG_DASH_DOT],
     :startArrow
     [ARROW_STYLE_UNSPECIFIED
      NONE
      STEALTH_ARROW
      FILL_ARROW
      FILL_CIRCLE
      FILL_SQUARE
      FILL_DIAMOND
      OPEN_ARROW
      OPEN_CIRCLE
      OPEN_SQUARE
      OPEN_DIAMOND],
     :endArrow
     [ARROW_STYLE_UNSPECIFIED
      NONE
      STEALTH_ARROW
      FILL_ARROW
      FILL_CIRCLE
      FILL_SQUARE
      FILL_DIAMOND
      OPEN_ARROW
      OPEN_CIRCLE
      OPEN_SQUARE
      OPEN_DIAMOND],
     :link
     {:url string,
      :relativeLink
      [RELATIVE_SLIDE_LINK_UNSPECIFIED
       NEXT_SLIDE
       PREVIOUS_SLIDE
       FIRST_SLIDE
       LAST_SLIDE],
      :pageObjectId string,
      :slideIndex integer},
     :startConnection
     {:connectedObjectId string, :connectionSiteIndex integer},
     :endConnection
     {:connectedObjectId string, :connectionSiteIndex integer}},
    :fields string},
   :updateTableCellProperties
   {:objectId string,
    :tableRange
    {:location {:rowIndex integer, :columnIndex integer},
     :rowSpan integer,
     :columnSpan integer},
    :tableCellProperties
    {:tableCellBackgroundFill
     {:propertyState [RENDERED NOT_RENDERED INHERIT],
      :solidFill SolidFill},
     :contentAlignment
     [CONTENT_ALIGNMENT_UNSPECIFIED
      CONTENT_ALIGNMENT_UNSUPPORTED
      TOP
      MIDDLE
      BOTTOM]},
    :fields string},
   :updatePageProperties
   {:objectId string,
    :pageProperties
    {:pageBackgroundFill
     {:propertyState [RENDERED NOT_RENDERED INHERIT],
      :solidFill SolidFill,
      :stretchedPictureFill StretchedPictureFill},
     :colorScheme {:colors [ThemeColorPair]}},
    :fields string},
   :createShape
   {:objectId string,
    :elementProperties
    {:pageObjectId string,
     :size {:width Dimension, :height Dimension},
     :transform
     {:scaleX number,
      :scaleY number,
      :shearX number,
      :shearY number,
      :translateX number,
      :translateY number,
      :unit [UNIT_UNSPECIFIED EMU PT]}},
    :shapeType
    [TYPE_UNSPECIFIED
     TEXT_BOX
     RECTANGLE
     ROUND_RECTANGLE
     ELLIPSE
     ARC
     BENT_ARROW
     BENT_UP_ARROW
     BEVEL
     BLOCK_ARC
     BRACE_PAIR
     BRACKET_PAIR
     CAN
     CHEVRON
     CHORD
     CLOUD
     CORNER
     CUBE
     CURVED_DOWN_ARROW
     CURVED_LEFT_ARROW
     CURVED_RIGHT_ARROW
     CURVED_UP_ARROW
     DECAGON
     DIAGONAL_STRIPE
     DIAMOND
     DODECAGON
     DONUT
     DOUBLE_WAVE
     DOWN_ARROW
     DOWN_ARROW_CALLOUT
     FOLDED_CORNER
     FRAME
     HALF_FRAME
     HEART
     HEPTAGON
     HEXAGON
     HOME_PLATE
     HORIZONTAL_SCROLL
     IRREGULAR_SEAL_1
     IRREGULAR_SEAL_2
     LEFT_ARROW
     LEFT_ARROW_CALLOUT
     LEFT_BRACE
     LEFT_BRACKET
     LEFT_RIGHT_ARROW
     LEFT_RIGHT_ARROW_CALLOUT
     LEFT_RIGHT_UP_ARROW
     LEFT_UP_ARROW
     LIGHTNING_BOLT
     MATH_DIVIDE
     MATH_EQUAL
     MATH_MINUS
     MATH_MULTIPLY
     MATH_NOT_EQUAL
     MATH_PLUS
     MOON
     NO_SMOKING
     NOTCHED_RIGHT_ARROW
     OCTAGON
     PARALLELOGRAM
     PENTAGON
     PIE
     PLAQUE
     PLUS
     QUAD_ARROW
     QUAD_ARROW_CALLOUT
     RIBBON
     RIBBON_2
     RIGHT_ARROW
     RIGHT_ARROW_CALLOUT
     RIGHT_BRACE
     RIGHT_BRACKET
     ROUND_1_RECTANGLE
     ROUND_2_DIAGONAL_RECTANGLE
     ROUND_2_SAME_RECTANGLE
     RIGHT_TRIANGLE
     SMILEY_FACE
     SNIP_1_RECTANGLE
     SNIP_2_DIAGONAL_RECTANGLE
     SNIP_2_SAME_RECTANGLE
     SNIP_ROUND_RECTANGLE
     STAR_10
     STAR_12
     STAR_16
     STAR_24
     STAR_32
     STAR_4
     STAR_5
     STAR_6
     STAR_7
     STAR_8
     STRIPED_RIGHT_ARROW
     SUN
     TRAPEZOID
     TRIANGLE
     UP_ARROW
     UP_ARROW_CALLOUT
     UP_DOWN_ARROW
     UTURN_ARROW
     VERTICAL_SCROLL
     WAVE
     WEDGE_ELLIPSE_CALLOUT
     WEDGE_RECTANGLE_CALLOUT
     WEDGE_ROUND_RECTANGLE_CALLOUT
     FLOW_CHART_ALTERNATE_PROCESS
     FLOW_CHART_COLLATE
     FLOW_CHART_CONNECTOR
     FLOW_CHART_DECISION
     FLOW_CHART_DELAY
     FLOW_CHART_DISPLAY
     FLOW_CHART_DOCUMENT
     FLOW_CHART_EXTRACT
     FLOW_CHART_INPUT_OUTPUT
     FLOW_CHART_INTERNAL_STORAGE
     FLOW_CHART_MAGNETIC_DISK
     FLOW_CHART_MAGNETIC_DRUM
     FLOW_CHART_MAGNETIC_TAPE
     FLOW_CHART_MANUAL_INPUT
     FLOW_CHART_MANUAL_OPERATION
     FLOW_CHART_MERGE
     FLOW_CHART_MULTIDOCUMENT
     FLOW_CHART_OFFLINE_STORAGE
     FLOW_CHART_OFFPAGE_CONNECTOR
     FLOW_CHART_ONLINE_STORAGE
     FLOW_CHART_OR
     FLOW_CHART_PREDEFINED_PROCESS
     FLOW_CHART_PREPARATION
     FLOW_CHART_PROCESS
     FLOW_CHART_PUNCHED_CARD
     FLOW_CHART_PUNCHED_TAPE
     FLOW_CHART_SORT
     FLOW_CHART_SUMMING_JUNCTION
     FLOW_CHART_TERMINATOR
     ARROW_EAST
     ARROW_NORTH_EAST
     ARROW_NORTH
     SPEECH
     STARBURST
     TEARDROP
     ELLIPSE_RIBBON
     ELLIPSE_RIBBON_2
     CLOUD_CALLOUT
     CUSTOM]},
   :insertText
   {:objectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer},
    :text string,
    :insertionIndex integer},
   :deleteParagraphBullets
   {:objectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer},
    :textRange
    {:startIndex integer,
     :endIndex integer,
     :type [RANGE_TYPE_UNSPECIFIED FIXED_RANGE FROM_START_INDEX ALL]}},
   :updateTableBorderProperties
   {:objectId string,
    :tableRange
    {:location {:rowIndex integer, :columnIndex integer},
     :rowSpan integer,
     :columnSpan integer},
    :borderPosition
    [ALL
     BOTTOM
     INNER
     INNER_HORIZONTAL
     INNER_VERTICAL
     LEFT
     OUTER
     RIGHT
     TOP],
    :tableBorderProperties
    {:tableBorderFill {:solidFill SolidFill},
     :weight {:magnitude number, :unit [UNIT_UNSPECIFIED EMU PT]},
     :dashStyle
     [DASH_STYLE_UNSPECIFIED
      SOLID
      DOT
      DASH
      DASH_DOT
      LONG_DASH
      LONG_DASH_DOT]},
    :fields string},
   :deleteObject {:objectId string},
   :createParagraphBullets
   {:objectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer},
    :textRange
    {:startIndex integer,
     :endIndex integer,
     :type [RANGE_TYPE_UNSPECIFIED FIXED_RANGE FROM_START_INDEX ALL]},
    :bulletPreset
    [BULLET_DISC_CIRCLE_SQUARE
     BULLET_DIAMONDX_ARROW3D_SQUARE
     BULLET_CHECKBOX
     BULLET_ARROW_DIAMOND_DISC
     BULLET_STAR_CIRCLE_SQUARE
     BULLET_ARROW3D_CIRCLE_SQUARE
     BULLET_LEFTTRIANGLE_DIAMOND_DISC
     BULLET_DIAMONDX_HOLLOWDIAMOND_SQUARE
     BULLET_DIAMOND_CIRCLE_SQUARE
     NUMBERED_DIGIT_ALPHA_ROMAN
     NUMBERED_DIGIT_ALPHA_ROMAN_PARENS
     NUMBERED_DIGIT_NESTED
     NUMBERED_UPPERALPHA_ALPHA_ROMAN
     NUMBERED_UPPERROMAN_UPPERALPHA_DIGIT
     NUMBERED_ZERODIGIT_ALPHA_ROMAN]},
   :deleteTableColumn
   {:tableObjectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer}},
   :updateVideoProperties
   {:objectId string,
    :videoProperties
    {:outline
     {:outlineFill OutlineFill,
      :weight Dimension,
      :dashStyle
      [DASH_STYLE_UNSPECIFIED
       SOLID
       DOT
       DASH
       DASH_DOT
       LONG_DASH
       LONG_DASH_DOT],
      :propertyState [RENDERED NOT_RENDERED INHERIT]},
     :autoPlay boolean,
     :start integer,
     :end integer,
     :mute boolean},
    :fields string},
   :createSlide
   {:objectId string,
    :insertionIndex integer,
    :slideLayoutReference
    {:predefinedLayout
     [PREDEFINED_LAYOUT_UNSPECIFIED
      BLANK
      CAPTION_ONLY
      TITLE
      TITLE_AND_BODY
      TITLE_AND_TWO_COLUMNS
      TITLE_ONLY
      SECTION_HEADER
      SECTION_TITLE_AND_DESCRIPTION
      ONE_COLUMN_TEXT
      MAIN_POINT
      BIG_NUMBER],
     :layoutId string},
    :placeholderIdMappings
    [{:layoutPlaceholder
      {:type
       [NONE
        BODY
        CHART
        CLIP_ART
        CENTERED_TITLE
        DIAGRAM
        DATE_AND_TIME
        FOOTER
        HEADER
        MEDIA
        OBJECT
        PICTURE
        SLIDE_NUMBER
        SUBTITLE
        TABLE
        TITLE
        SLIDE_IMAGE],
       :index integer,
       :parentObjectId string},
      :layoutPlaceholderObjectId string,
      :objectId string}]},
   :unmergeTableCells
   {:objectId string,
    :tableRange
    {:location {:rowIndex integer, :columnIndex integer},
     :rowSpan integer,
     :columnSpan integer}},
   :ungroupObjects {:objectIds [string]},
   :updateSlidesPosition
   {:slideObjectIds [string], :insertionIndex integer},
   :insertTableColumns
   {:tableObjectId string,
    :cellLocation {:rowIndex integer, :columnIndex integer},
    :insertRight boolean,
    :number integer},
   :createTable
   {:objectId string,
    :elementProperties
    {:pageObjectId string,
     :size {:width Dimension, :height Dimension},
     :transform
     {:scaleX number,
      :scaleY number,
      :shearX number,
      :shearY number,
      :translateX number,
      :translateY number,
      :unit [UNIT_UNSPECIFIED EMU PT]}},
    :rows integer,
    :columns integer}}],
 :writeControl {:requiredRevisionId string}}"
  [presentationId BatchUpdatePresentationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://slides.googleapis.com/v1/presentations/{presentationId}:batchUpdate",
     :uri-template-args {:presentationId presentationId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/presentations"
      "https://www.googleapis.com/auth/spreadsheets"
      "https://www.googleapis.com/auth/spreadsheets.readonly"],
     :body BatchUpdatePresentationRequest}))

(defn presentations-pages-get
  "Gets the latest version of the specified page in the presentation.
https://developers.google.com/slides/reference/rest/v1/presentations/pages/get

presentationId <string> The ID of the presentation to retrieve.
pageObjectId <string> The object ID of the page to retrieve."
  [presentationId pageObjectId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://slides.googleapis.com/v1/presentations/{presentationId}/pages/{pageObjectId}",
     :uri-template-args
     {:presentationId presentationId, :pageObjectId pageObjectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/presentations"
      "https://www.googleapis.com/auth/presentations.readonly"]}))

(defn presentations-pages-getThumbnail
  "Generates a thumbnail of the latest version of the specified page in the presentation and returns a URL to the thumbnail image. This request counts as an [expensive read request](/slides/limits) for quota purposes.
https://developers.google.com/slides/reference/rest/v1/presentations/pages/getThumbnail

presentationId <string> The ID of the presentation to retrieve.
pageObjectId <string> The object ID of the page whose thumbnail to retrieve.

optional:
thumbnailProperties.mimeType <string> The optional mime type of the thumbnail image. If you don't specify the mime type, the mime type defaults to PNG.
thumbnailProperties.thumbnailSize <string> The optional thumbnail image size. If you don't specify the size, the server chooses a default size of the image."
  ([presentationId pageObjectId]
    (presentations-pages-getThumbnail presentationId pageObjectId nil))
  ([presentationId pageObjectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://slides.googleapis.com/v1/presentations/{presentationId}/pages/{pageObjectId}/thumbnail",
       :uri-template-args
       {:presentationId presentationId, :pageObjectId pageObjectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.readonly"
        "https://www.googleapis.com/auth/presentations"
        "https://www.googleapis.com/auth/presentations.readonly"]})))
