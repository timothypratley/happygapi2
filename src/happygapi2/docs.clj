(ns happygapi2.docs
  "Google Docs API
Reads and writes Google Docs documents.
See: https://developers.google.com/docs/"
  (:require [happy.oauth2.client :as client]))

(defn documents-get
  "Gets the latest version of the specified document.
https://developers.google.com/docs/api/reference/rest/v1/documents/get

documentId <string> The ID of the document to retrieve.

optional:
suggestionsViewMode <string> The suggestions view mode to apply to the document. This allows viewing the document with all suggestions inline, accepted or rejected. If one is not specified, DEFAULT_FOR_CURRENT_ACCESS is used."
  ([documentId] (documents-get documentId nil))
  ([documentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://docs.googleapis.com/v1/documents/{documentId}",
       :uri-template-args {:documentId documentId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/documents"
        "https://www.googleapis.com/auth/documents.readonly"
        "https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn documents-create
  "Creates a blank document using the title given in the request. Other fields in the request, including any provided content, are ignored. Returns the created document.
https://developers.google.com/docs/api/reference/rest/v1/documents/create

Document:
{:suggestedDocumentStyleChanges object,
 :footnotes object,
 :lists object,
 :positionedObjects object,
 :footers object,
 :inlineObjects object,
 :namedRanges object,
 :revisionId string,
 :namedStyles
 {:styles
  [{:namedStyleType
    [NAMED_STYLE_TYPE_UNSPECIFIED
     NORMAL_TEXT
     TITLE
     SUBTITLE
     HEADING_1
     HEADING_2
     HEADING_3
     HEADING_4
     HEADING_5
     HEADING_6],
    :textStyle
    {:bold boolean,
     :smallCaps boolean,
     :baselineOffset
     [BASELINE_OFFSET_UNSPECIFIED NONE SUPERSCRIPT SUBSCRIPT],
     :underline boolean,
     :link {:url string, :bookmarkId string, :headingId string},
     :strikethrough boolean,
     :fontSize {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :backgroundColor {:color Color},
     :italic boolean,
     :foregroundColor {:color Color},
     :weightedFontFamily {:fontFamily string, :weight integer}},
    :paragraphStyle
    {:keepWithNext boolean,
     :indentStart {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :keepLinesTogether boolean,
     :avoidWidowAndOrphan boolean,
     :spacingMode
     [SPACING_MODE_UNSPECIFIED NEVER_COLLAPSE COLLAPSE_LISTS],
     :tabStops
     [{:offset Dimension,
       :alignment [TAB_STOP_ALIGNMENT_UNSPECIFIED START CENTER END]}],
     :borderTop
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :alignment [ALIGNMENT_UNSPECIFIED START CENTER END JUSTIFIED],
     :borderBottom
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :shading {:backgroundColor OptionalColor},
     :borderBetween
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :indentFirstLine {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :borderRight
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :borderLeft
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :headingId string,
     :pageBreakBefore boolean,
     :indentEnd {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :spaceAbove {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :lineSpacing number,
     :spaceBelow {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :namedStyleType
     [NAMED_STYLE_TYPE_UNSPECIFIED
      NORMAL_TEXT
      TITLE
      SUBTITLE
      HEADING_1
      HEADING_2
      HEADING_3
      HEADING_4
      HEADING_5
      HEADING_6],
     :direction
     [CONTENT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT]}}]},
 :suggestedNamedStylesChanges object,
 :documentStyle
 {:defaultHeaderId string,
  :marginLeft {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
  :flipPageOrientation boolean,
  :evenPageFooterId string,
  :useFirstPageHeaderFooter boolean,
  :useCustomHeaderFooterMargins boolean,
  :background {:color {:color {:rgbColor RgbColor}}},
  :marginTop {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
  :pageNumberStart integer,
  :firstPageHeaderId string,
  :defaultFooterId string,
  :firstPageFooterId string,
  :pageSize
  {:height {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
   :width {:magnitude number, :unit [UNIT_UNSPECIFIED PT]}},
  :evenPageHeaderId string,
  :marginBottom {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
  :marginHeader {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
  :useEvenPageHeaderFooter boolean,
  :marginFooter {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
  :marginRight {:magnitude number, :unit [UNIT_UNSPECIFIED PT]}},
 :title string,
 :suggestionsViewMode
 [DEFAULT_FOR_CURRENT_ACCESS
  SUGGESTIONS_INLINE
  PREVIEW_SUGGESTIONS_ACCEPTED
  PREVIEW_WITHOUT_SUGGESTIONS],
 :headers object,
 :documentId string,
 :body
 {:content
  [{:startIndex integer,
    :endIndex integer,
    :paragraph
    {:elements
     [{:footnoteReference FootnoteReference,
       :person Person,
       :horizontalRule HorizontalRule,
       :richLink RichLink,
       :columnBreak ColumnBreak,
       :pageBreak PageBreak,
       :inlineObjectElement InlineObjectElement,
       :autoText AutoText,
       :textRun TextRun,
       :endIndex integer,
       :startIndex integer,
       :equation Equation}],
     :paragraphStyle
     {:keepWithNext boolean,
      :indentStart Dimension,
      :keepLinesTogether boolean,
      :avoidWidowAndOrphan boolean,
      :spacingMode
      [SPACING_MODE_UNSPECIFIED NEVER_COLLAPSE COLLAPSE_LISTS],
      :tabStops [TabStop],
      :borderTop ParagraphBorder,
      :alignment [ALIGNMENT_UNSPECIFIED START CENTER END JUSTIFIED],
      :borderBottom ParagraphBorder,
      :shading Shading,
      :borderBetween ParagraphBorder,
      :indentFirstLine Dimension,
      :borderRight ParagraphBorder,
      :borderLeft ParagraphBorder,
      :headingId string,
      :pageBreakBefore boolean,
      :indentEnd Dimension,
      :spaceAbove Dimension,
      :lineSpacing number,
      :spaceBelow Dimension,
      :namedStyleType
      [NAMED_STYLE_TYPE_UNSPECIFIED
       NORMAL_TEXT
       TITLE
       SUBTITLE
       HEADING_1
       HEADING_2
       HEADING_3
       HEADING_4
       HEADING_5
       HEADING_6],
      :direction
      [CONTENT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT]},
     :suggestedParagraphStyleChanges object,
     :bullet
     {:listId string, :nestingLevel integer, :textStyle TextStyle},
     :suggestedBulletChanges object,
     :positionedObjectIds [string],
     :suggestedPositionedObjectIds object},
    :sectionBreak
    {:suggestedInsertionIds [string],
     :suggestedDeletionIds [string],
     :sectionStyle
     {:defaultHeaderId string,
      :marginLeft Dimension,
      :flipPageOrientation boolean,
      :evenPageFooterId string,
      :useFirstPageHeaderFooter boolean,
      :contentDirection
      [CONTENT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT],
      :marginTop Dimension,
      :sectionType [SECTION_TYPE_UNSPECIFIED CONTINUOUS NEXT_PAGE],
      :pageNumberStart integer,
      :firstPageHeaderId string,
      :defaultFooterId string,
      :firstPageFooterId string,
      :evenPageHeaderId string,
      :marginBottom Dimension,
      :columnSeparatorStyle
      [COLUMN_SEPARATOR_STYLE_UNSPECIFIED NONE BETWEEN_EACH_COLUMN],
      :marginHeader Dimension,
      :columnProperties [SectionColumnProperties],
      :marginFooter Dimension,
      :marginRight Dimension}},
    :table
    {:rows integer,
     :columns integer,
     :tableRows
     [{:startIndex integer,
       :endIndex integer,
       :tableCells [TableCell],
       :suggestedInsertionIds [string],
       :suggestedDeletionIds [string],
       :tableRowStyle TableRowStyle,
       :suggestedTableRowStyleChanges object}],
     :suggestedInsertionIds [string],
     :suggestedDeletionIds [string],
     :tableStyle {:tableColumnProperties [TableColumnProperties]}},
    :tableOfContents
    {:content
     [{:startIndex integer,
       :endIndex integer,
       :paragraph Paragraph,
       :sectionBreak SectionBreak,
       :table Table,
       :tableOfContents TableOfContents}],
     :suggestedInsertionIds [string],
     :suggestedDeletionIds [string]}}]}}"
  [Document]
  (client/api-request
    {:method "POST",
     :uri-template "https://docs.googleapis.com/v1/documents",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/documents"
      "https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"],
     :body Document}))

(defn documents-batchUpdate
  "Applies one or more updates to the document. Each request is validated before being applied. If any request is not valid, then the entire request will fail and nothing will be applied. Some requests have replies to give you some information about how they are applied. Other requests do not need to return information; these each return an empty reply. The order of replies matches that of the requests. For example, suppose you call batchUpdate with four updates, and only the third one returns information. The response would have two empty replies, the reply to the third request, and another empty reply, in that order. Because other users may be editing the document, the document might not exactly reflect your changes: your changes may be altered with respect to collaborator changes. If there are no collaborators, the document should reflect your changes. In any case, the updates in your request are guaranteed to be applied together atomically.
https://developers.google.com/docs/api/reference/rest/v1/documents/batchUpdate

documentId <string> The ID of the document to update.
BatchUpdateDocumentRequest:
{:requests
 [{:updateSectionStyle
   {:range {:segmentId string, :startIndex integer, :endIndex integer},
    :sectionStyle
    {:defaultHeaderId string,
     :marginLeft {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :flipPageOrientation boolean,
     :evenPageFooterId string,
     :useFirstPageHeaderFooter boolean,
     :contentDirection
     [CONTENT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT],
     :marginTop {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :sectionType [SECTION_TYPE_UNSPECIFIED CONTINUOUS NEXT_PAGE],
     :pageNumberStart integer,
     :firstPageHeaderId string,
     :defaultFooterId string,
     :firstPageFooterId string,
     :evenPageHeaderId string,
     :marginBottom {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :columnSeparatorStyle
     [COLUMN_SEPARATOR_STYLE_UNSPECIFIED NONE BETWEEN_EACH_COLUMN],
     :marginHeader {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :columnProperties [{:width Dimension, :paddingEnd Dimension}],
     :marginFooter {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :marginRight {:magnitude number, :unit [UNIT_UNSPECIFIED PT]}},
    :fields string},
   :deletePositionedObject {:objectId string},
   :createNamedRange
   {:name string,
    :range
    {:segmentId string, :startIndex integer, :endIndex integer}},
   :replaceNamedRangeContent
   {:text string, :namedRangeId string, :namedRangeName string},
   :deleteContentRange
   {:range
    {:segmentId string, :startIndex integer, :endIndex integer}},
   :createFooter
   {:type [HEADER_FOOTER_TYPE_UNSPECIFIED DEFAULT],
    :sectionBreakLocation {:segmentId string, :index integer}},
   :insertTable
   {:location {:segmentId string, :index integer},
    :endOfSegmentLocation {:segmentId string},
    :rows integer,
    :columns integer},
   :deleteTableRow
   {:tableCellLocation
    {:tableStartLocation {:segmentId string, :index integer},
     :rowIndex integer,
     :columnIndex integer}},
   :insertTableColumn
   {:tableCellLocation
    {:tableStartLocation {:segmentId string, :index integer},
     :rowIndex integer,
     :columnIndex integer},
    :insertRight boolean},
   :updateTextStyle
   {:range {:segmentId string, :startIndex integer, :endIndex integer},
    :textStyle
    {:bold boolean,
     :smallCaps boolean,
     :baselineOffset
     [BASELINE_OFFSET_UNSPECIFIED NONE SUPERSCRIPT SUBSCRIPT],
     :underline boolean,
     :link {:url string, :bookmarkId string, :headingId string},
     :strikethrough boolean,
     :fontSize {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :backgroundColor {:color Color},
     :italic boolean,
     :foregroundColor {:color Color},
     :weightedFontFamily {:fontFamily string, :weight integer}},
    :fields string},
   :replaceAllText
   {:replaceText string,
    :containsText {:text string, :matchCase boolean}},
   :updateTableCellStyle
   {:tableRange
    {:tableCellLocation
     {:tableStartLocation Location,
      :rowIndex integer,
      :columnIndex integer},
     :rowSpan integer,
     :columnSpan integer},
    :tableStartLocation {:segmentId string, :index integer},
    :tableCellStyle
    {:rowSpan integer,
     :columnSpan integer,
     :paddingBottom {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :paddingTop {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :paddingRight {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :borderTop
     {:color OptionalColor,
      :width Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :paddingLeft {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :borderBottom
     {:color OptionalColor,
      :width Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :contentAlignment
     [CONTENT_ALIGNMENT_UNSPECIFIED
      CONTENT_ALIGNMENT_UNSUPPORTED
      TOP
      MIDDLE
      BOTTOM],
     :borderRight
     {:color OptionalColor,
      :width Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :borderLeft
     {:color OptionalColor,
      :width Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :backgroundColor {:color Color}},
    :fields string},
   :insertInlineImage
   {:location {:segmentId string, :index integer},
    :endOfSegmentLocation {:segmentId string},
    :uri string,
    :objectSize
    {:height {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :width {:magnitude number, :unit [UNIT_UNSPECIFIED PT]}}},
   :updateDocumentStyle
   {:documentStyle
    {:defaultHeaderId string,
     :marginLeft {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :flipPageOrientation boolean,
     :evenPageFooterId string,
     :useFirstPageHeaderFooter boolean,
     :useCustomHeaderFooterMargins boolean,
     :background {:color OptionalColor},
     :marginTop {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :pageNumberStart integer,
     :firstPageHeaderId string,
     :defaultFooterId string,
     :firstPageFooterId string,
     :pageSize {:height Dimension, :width Dimension},
     :evenPageHeaderId string,
     :marginBottom {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :marginHeader {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :useEvenPageHeaderFooter boolean,
     :marginFooter {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :marginRight {:magnitude number, :unit [UNIT_UNSPECIFIED PT]}},
    :fields string},
   :deleteHeader {:headerId string},
   :mergeTableCells
   {:tableRange
    {:tableCellLocation
     {:tableStartLocation Location,
      :rowIndex integer,
      :columnIndex integer},
     :rowSpan integer,
     :columnSpan integer}},
   :updateTableColumnProperties
   {:tableStartLocation {:segmentId string, :index integer},
    :columnIndices [integer],
    :tableColumnProperties
    {:widthType
     [WIDTH_TYPE_UNSPECIFIED EVENLY_DISTRIBUTED FIXED_WIDTH],
     :width {:magnitude number, :unit [UNIT_UNSPECIFIED PT]}},
    :fields string},
   :createHeader
   {:type [HEADER_FOOTER_TYPE_UNSPECIFIED DEFAULT],
    :sectionBreakLocation {:segmentId string, :index integer}},
   :updateTableRowStyle
   {:tableStartLocation {:segmentId string, :index integer},
    :rowIndices [integer],
    :tableRowStyle
    {:minRowHeight {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :tableHeader boolean,
     :preventOverflow boolean},
    :fields string},
   :updateParagraphStyle
   {:range {:segmentId string, :startIndex integer, :endIndex integer},
    :paragraphStyle
    {:keepWithNext boolean,
     :indentStart {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :keepLinesTogether boolean,
     :avoidWidowAndOrphan boolean,
     :spacingMode
     [SPACING_MODE_UNSPECIFIED NEVER_COLLAPSE COLLAPSE_LISTS],
     :tabStops
     [{:offset Dimension,
       :alignment [TAB_STOP_ALIGNMENT_UNSPECIFIED START CENTER END]}],
     :borderTop
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :alignment [ALIGNMENT_UNSPECIFIED START CENTER END JUSTIFIED],
     :borderBottom
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :shading {:backgroundColor OptionalColor},
     :borderBetween
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :indentFirstLine {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :borderRight
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :borderLeft
     {:color OptionalColor,
      :width Dimension,
      :padding Dimension,
      :dashStyle [DASH_STYLE_UNSPECIFIED SOLID DOT DASH]},
     :headingId string,
     :pageBreakBefore boolean,
     :indentEnd {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :spaceAbove {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :lineSpacing number,
     :spaceBelow {:magnitude number, :unit [UNIT_UNSPECIFIED PT]},
     :namedStyleType
     [NAMED_STYLE_TYPE_UNSPECIFIED
      NORMAL_TEXT
      TITLE
      SUBTITLE
      HEADING_1
      HEADING_2
      HEADING_3
      HEADING_4
      HEADING_5
      HEADING_6],
     :direction
     [CONTENT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT]},
    :fields string},
   :replaceImage
   {:imageObjectId string,
    :uri string,
    :imageReplaceMethod
    [IMAGE_REPLACE_METHOD_UNSPECIFIED CENTER_CROP]},
   :deleteFooter {:footerId string},
   :insertPageBreak
   {:location {:segmentId string, :index integer},
    :endOfSegmentLocation {:segmentId string}},
   :pinTableHeaderRows
   {:tableStartLocation {:segmentId string, :index integer},
    :pinnedHeaderRowsCount integer},
   :insertText
   {:location {:segmentId string, :index integer},
    :endOfSegmentLocation {:segmentId string},
    :text string},
   :deleteParagraphBullets
   {:range
    {:segmentId string, :startIndex integer, :endIndex integer}},
   :deleteNamedRange {:namedRangeId string, :name string},
   :createParagraphBullets
   {:range {:segmentId string, :startIndex integer, :endIndex integer},
    :bulletPreset
    [BULLET_GLYPH_PRESET_UNSPECIFIED
     BULLET_DISC_CIRCLE_SQUARE
     BULLET_DIAMONDX_ARROW3D_SQUARE
     BULLET_CHECKBOX
     BULLET_ARROW_DIAMOND_DISC
     BULLET_STAR_CIRCLE_SQUARE
     BULLET_ARROW3D_CIRCLE_SQUARE
     BULLET_LEFTTRIANGLE_DIAMOND_DISC
     BULLET_DIAMONDX_HOLLOWDIAMOND_SQUARE
     BULLET_DIAMOND_CIRCLE_SQUARE
     NUMBERED_DECIMAL_ALPHA_ROMAN
     NUMBERED_DECIMAL_ALPHA_ROMAN_PARENS
     NUMBERED_DECIMAL_NESTED
     NUMBERED_UPPERALPHA_ALPHA_ROMAN
     NUMBERED_UPPERROMAN_UPPERALPHA_DECIMAL
     NUMBERED_ZERODECIMAL_ALPHA_ROMAN]},
   :deleteTableColumn
   {:tableCellLocation
    {:tableStartLocation {:segmentId string, :index integer},
     :rowIndex integer,
     :columnIndex integer}},
   :unmergeTableCells
   {:tableRange
    {:tableCellLocation
     {:tableStartLocation Location,
      :rowIndex integer,
      :columnIndex integer},
     :rowSpan integer,
     :columnSpan integer}},
   :createFootnote
   {:location {:segmentId string, :index integer},
    :endOfSegmentLocation {:segmentId string}},
   :insertTableRow
   {:tableCellLocation
    {:tableStartLocation {:segmentId string, :index integer},
     :rowIndex integer,
     :columnIndex integer},
    :insertBelow boolean},
   :insertSectionBreak
   {:location {:segmentId string, :index integer},
    :endOfSegmentLocation {:segmentId string},
    :sectionType [SECTION_TYPE_UNSPECIFIED CONTINUOUS NEXT_PAGE]}}],
 :writeControl {:requiredRevisionId string, :targetRevisionId string}}"
  [documentId BatchUpdateDocumentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://docs.googleapis.com/v1/documents/{documentId}:batchUpdate",
     :uri-template-args {:documentId documentId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/documents"
      "https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"],
     :body BatchUpdateDocumentRequest}))
