(ns happygapi2.sheets
  "Google Sheets API
Reads and writes Google Sheets.
See: https://developers.google.com/sheets/"
  (:require [happy.oauth2.client :as client]))

(defn spreadsheets-create
  "Creates a spreadsheet, returning the newly created spreadsheet.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/create

Spreadsheet:
{:spreadsheetId string,
 :properties
 {:title string,
  :locale string,
  :autoRecalc
  [RECALCULATION_INTERVAL_UNSPECIFIED ON_CHANGE MINUTE HOUR],
  :timeZone string,
  :defaultFormat
  {:textFormat
   {:bold boolean,
    :foregroundColorStyle
    {:rgbColor Color,
     :themeColor
     [THEME_COLOR_TYPE_UNSPECIFIED
      TEXT
      BACKGROUND
      ACCENT1
      ACCENT2
      ACCENT3
      ACCENT4
      ACCENT5
      ACCENT6
      LINK]},
    :underline boolean,
    :fontFamily string,
    :link {:uri string},
    :strikethrough boolean,
    :fontSize integer,
    :italic boolean,
    :foregroundColor
    {:red number, :green number, :blue number, :alpha number}},
   :textRotation {:angle integer, :vertical boolean},
   :textDirection
   [TEXT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT],
   :borders
   {:top
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color Color,
     :colorStyle ColorStyle},
    :bottom
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color Color,
     :colorStyle ColorStyle},
    :left
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color Color,
     :colorStyle ColorStyle},
    :right
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color Color,
     :colorStyle ColorStyle}},
   :numberFormat
   {:type
    [NUMBER_FORMAT_TYPE_UNSPECIFIED
     TEXT
     NUMBER
     PERCENT
     CURRENCY
     DATE
     TIME
     DATE_TIME
     SCIENTIFIC],
    :pattern string},
   :verticalAlignment [VERTICAL_ALIGN_UNSPECIFIED TOP MIDDLE BOTTOM],
   :hyperlinkDisplayType
   [HYPERLINK_DISPLAY_TYPE_UNSPECIFIED LINKED PLAIN_TEXT],
   :padding
   {:top integer, :right integer, :bottom integer, :left integer},
   :wrapStrategy
   [WRAP_STRATEGY_UNSPECIFIED OVERFLOW_CELL LEGACY_WRAP CLIP WRAP],
   :backgroundColorStyle
   {:rgbColor
    {:red number, :green number, :blue number, :alpha number},
    :themeColor
    [THEME_COLOR_TYPE_UNSPECIFIED
     TEXT
     BACKGROUND
     ACCENT1
     ACCENT2
     ACCENT3
     ACCENT4
     ACCENT5
     ACCENT6
     LINK]},
   :backgroundColor
   {:red number, :green number, :blue number, :alpha number},
   :horizontalAlignment
   [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
  :iterativeCalculationSettings
  {:maxIterations integer, :convergenceThreshold number},
  :spreadsheetTheme
  {:primaryFontFamily string,
   :themeColors
   [{:colorType
     [THEME_COLOR_TYPE_UNSPECIFIED
      TEXT
      BACKGROUND
      ACCENT1
      ACCENT2
      ACCENT3
      ACCENT4
      ACCENT5
      ACCENT6
      LINK],
     :color
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]}}]},
  :importFunctionsExternalUrlAccessAllowed boolean},
 :sheets
 [{:properties
   {:tabColor
    {:red number, :green number, :blue number, :alpha number},
    :sheetId integer,
    :index integer,
    :tabColorStyle
    {:rgbColor
     {:red number, :green number, :blue number, :alpha number},
     :themeColor
     [THEME_COLOR_TYPE_UNSPECIFIED
      TEXT
      BACKGROUND
      ACCENT1
      ACCENT2
      ACCENT3
      ACCENT4
      ACCENT5
      ACCENT6
      LINK]},
    :dataSourceSheetProperties
    {:dataSourceId string,
     :columns
     [{:reference DataSourceColumnReference, :formula string}],
     :dataExecutionStatus
     {:state
      [DATA_EXECUTION_STATE_UNSPECIFIED
       NOT_STARTED
       RUNNING
       CANCELLING
       SUCCEEDED
       FAILED],
      :errorCode
      [DATA_EXECUTION_ERROR_CODE_UNSPECIFIED
       TIMED_OUT
       TOO_MANY_ROWS
       TOO_MANY_COLUMNS
       TOO_MANY_CELLS
       ENGINE
       PARAMETER_INVALID
       UNSUPPORTED_DATA_TYPE
       DUPLICATE_COLUMN_NAMES
       INTERRUPTED
       CONCURRENT_QUERY
       OTHER
       TOO_MANY_CHARS_PER_CELL
       DATA_NOT_FOUND
       PERMISSION_DENIED
       MISSING_COLUMN_ALIAS
       OBJECT_NOT_FOUND
       OBJECT_IN_ERROR_STATE
       OBJECT_SPEC_INVALID
       DATA_EXECUTION_CANCELLED],
      :errorMessage string,
      :lastRefreshTime string}},
    :rightToLeft boolean,
    :title string,
    :hidden boolean,
    :sheetType [SHEET_TYPE_UNSPECIFIED GRID OBJECT DATA_SOURCE],
    :gridProperties
    {:rowCount integer,
     :columnCount integer,
     :frozenRowCount integer,
     :frozenColumnCount integer,
     :hideGridlines boolean,
     :rowGroupControlAfter boolean,
     :columnGroupControlAfter boolean}},
   :filterViews
   [{:filterViewId integer,
     :title string,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :namedRangeId string,
     :sortSpecs
     [{:dimensionIndex integer,
       :dataSourceColumnReference {:name string},
       :sortOrder [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING],
       :foregroundColor
       {:red number, :green number, :blue number, :alpha number},
       :foregroundColorStyle
       {:rgbColor Color,
        :themeColor
        [THEME_COLOR_TYPE_UNSPECIFIED
         TEXT
         BACKGROUND
         ACCENT1
         ACCENT2
         ACCENT3
         ACCENT4
         ACCENT5
         ACCENT6
         LINK]},
       :backgroundColor
       {:red number, :green number, :blue number, :alpha number},
       :backgroundColorStyle
       {:rgbColor Color,
        :themeColor
        [THEME_COLOR_TYPE_UNSPECIFIED
         TEXT
         BACKGROUND
         ACCENT1
         ACCENT2
         ACCENT3
         ACCENT4
         ACCENT5
         ACCENT6
         LINK]}}],
     :criteria object,
     :filterSpecs
     [{:columnIndex integer,
       :dataSourceColumnReference {:name string},
       :filterCriteria
       {:hiddenValues [string],
        :condition BooleanCondition,
        :visibleBackgroundColor Color,
        :visibleBackgroundColorStyle ColorStyle,
        :visibleForegroundColor Color,
        :visibleForegroundColorStyle ColorStyle}}]}],
   :slicers
   [{:slicerId integer,
     :spec
     {:textFormat
      {:bold boolean,
       :foregroundColorStyle ColorStyle,
       :underline boolean,
       :fontFamily string,
       :link Link,
       :strikethrough boolean,
       :fontSize integer,
       :italic boolean,
       :foregroundColor Color},
      :dataRange
      {:sheetId integer,
       :startRowIndex integer,
       :endRowIndex integer,
       :startColumnIndex integer,
       :endColumnIndex integer},
      :filterCriteria
      {:hiddenValues [string],
       :condition BooleanCondition,
       :visibleBackgroundColor Color,
       :visibleBackgroundColorStyle ColorStyle,
       :visibleForegroundColor Color,
       :visibleForegroundColorStyle ColorStyle},
      :title string,
      :applyToPivotTables boolean,
      :columnIndex integer,
      :backgroundColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :backgroundColor
      {:red number, :green number, :blue number, :alpha number},
      :horizontalAlignment
      [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
     :position
     {:sheetId integer,
      :overlayPosition
      {:anchorCell GridCoordinate,
       :offsetXPixels integer,
       :offsetYPixels integer,
       :widthPixels integer,
       :heightPixels integer},
      :newSheet boolean}}],
   :columnGroups
   [{:range
     {:sheetId integer,
      :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
      :startIndex integer,
      :endIndex integer},
     :depth integer,
     :collapsed boolean}],
   :developerMetadata
   [{:metadataId integer,
     :metadataKey string,
     :metadataValue string,
     :location
     {:locationType
      [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
       ROW
       COLUMN
       SHEET
       SPREADSHEET],
      :spreadsheet boolean,
      :sheetId integer,
      :dimensionRange
      {:sheetId integer,
       :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
       :startIndex integer,
       :endIndex integer}},
     :visibility
     [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]}],
   :protectedRanges
   [{:protectedRangeId integer,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :namedRangeId string,
     :description string,
     :warningOnly boolean,
     :requestingUserCanEdit boolean,
     :unprotectedRanges
     [{:sheetId integer,
       :startRowIndex integer,
       :endRowIndex integer,
       :startColumnIndex integer,
       :endColumnIndex integer}],
     :editors
     {:users [string],
      :groups [string],
      :domainUsersCanEdit boolean}}],
   :rowGroups
   [{:range
     {:sheetId integer,
      :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
      :startIndex integer,
      :endIndex integer},
     :depth integer,
     :collapsed boolean}],
   :bandedRanges
   [{:bandedRangeId integer,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :rowProperties
     {:headerColor
      {:red number, :green number, :blue number, :alpha number},
      :headerColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :firstBandColor
      {:red number, :green number, :blue number, :alpha number},
      :firstBandColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :secondBandColor
      {:red number, :green number, :blue number, :alpha number},
      :secondBandColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :footerColor
      {:red number, :green number, :blue number, :alpha number},
      :footerColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]}},
     :columnProperties
     {:headerColor
      {:red number, :green number, :blue number, :alpha number},
      :headerColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :firstBandColor
      {:red number, :green number, :blue number, :alpha number},
      :firstBandColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :secondBandColor
      {:red number, :green number, :blue number, :alpha number},
      :secondBandColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :footerColor
      {:red number, :green number, :blue number, :alpha number},
      :footerColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]}}}],
   :basicFilter
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :sortSpecs
    [{:dimensionIndex integer,
      :dataSourceColumnReference {:name string},
      :sortOrder [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING],
      :foregroundColor
      {:red number, :green number, :blue number, :alpha number},
      :foregroundColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :backgroundColor
      {:red number, :green number, :blue number, :alpha number},
      :backgroundColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]}}],
    :criteria object,
    :filterSpecs
    [{:columnIndex integer,
      :dataSourceColumnReference {:name string},
      :filterCriteria
      {:hiddenValues [string],
       :condition BooleanCondition,
       :visibleBackgroundColor Color,
       :visibleBackgroundColorStyle ColorStyle,
       :visibleForegroundColor Color,
       :visibleForegroundColorStyle ColorStyle}}]},
   :merges
   [{:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer}],
   :charts
   [{:chartId integer,
     :spec
     {:subtitleTextFormat
      {:bold boolean,
       :foregroundColorStyle ColorStyle,
       :underline boolean,
       :fontFamily string,
       :link Link,
       :strikethrough boolean,
       :fontSize integer,
       :italic boolean,
       :foregroundColor Color},
      :titleTextPosition
      {:horizontalAlignment
       [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
      :pieChart
      {:legendPosition
       [PIE_CHART_LEGEND_POSITION_UNSPECIFIED
        BOTTOM_LEGEND
        LEFT_LEGEND
        RIGHT_LEGEND
        TOP_LEGEND
        NO_LEGEND
        LABELED_LEGEND],
       :domain ChartData,
       :series ChartData,
       :threeDimensional boolean,
       :pieHole number},
      :sortSpecs
      [{:dimensionIndex integer,
        :dataSourceColumnReference DataSourceColumnReference,
        :sortOrder [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING],
        :foregroundColor Color,
        :foregroundColorStyle ColorStyle,
        :backgroundColor Color,
        :backgroundColorStyle ColorStyle}],
      :candlestickChart
      {:domain CandlestickDomain, :data [CandlestickData]},
      :filterSpecs
      [{:columnIndex integer,
        :dataSourceColumnReference DataSourceColumnReference,
        :filterCriteria FilterCriteria}],
      :altText string,
      :dataSourceChartProperties
      {:dataSourceId string, :dataExecutionStatus DataExecutionStatus},
      :basicChart
      {:lineSmoothing boolean,
       :totalDataLabel DataLabel,
       :chartType
       [BASIC_CHART_TYPE_UNSPECIFIED
        BAR
        LINE
        AREA
        COLUMN
        SCATTER
        COMBO
        STEPPED_AREA],
       :series [BasicChartSeries],
       :domains [BasicChartDomain],
       :legendPosition
       [BASIC_CHART_LEGEND_POSITION_UNSPECIFIED
        BOTTOM_LEGEND
        LEFT_LEGEND
        RIGHT_LEGEND
        TOP_LEGEND
        NO_LEGEND],
       :threeDimensional boolean,
       :compareMode
       [BASIC_CHART_COMPARE_MODE_UNSPECIFIED DATUM CATEGORY],
       :interpolateNulls boolean,
       :axis [BasicChartAxis],
       :headerCount integer,
       :stackedType
       [BASIC_CHART_STACKED_TYPE_UNSPECIFIED
        NOT_STACKED
        STACKED
        PERCENT_STACKED]},
      :subtitleTextPosition
      {:horizontalAlignment
       [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
      :scorecardChart
      {:keyValueData ChartData,
       :baselineValueData ChartData,
       :aggregateType
       [CHART_AGGREGATE_TYPE_UNSPECIFIED
        AVERAGE
        COUNT
        MAX
        MEDIAN
        MIN
        SUM],
       :keyValueFormat KeyValueFormat,
       :baselineValueFormat BaselineValueFormat,
       :scaleFactor number,
       :numberFormatSource
       [CHART_NUMBER_FORMAT_SOURCE_UNDEFINED FROM_DATA CUSTOM],
       :customFormatOptions ChartCustomNumberFormatOptions},
      :waterfallChart
      {:domain WaterfallChartDomain,
       :series [WaterfallChartSeries],
       :stackedType
       [WATERFALL_STACKED_TYPE_UNSPECIFIED STACKED SEQUENTIAL],
       :firstValueIsTotal boolean,
       :hideConnectorLines boolean,
       :connectorLineStyle LineStyle,
       :totalDataLabel DataLabel},
      :maximized boolean,
      :title string,
      :histogramChart
      {:series [HistogramSeries],
       :legendPosition
       [HISTOGRAM_CHART_LEGEND_POSITION_UNSPECIFIED
        BOTTOM_LEGEND
        LEFT_LEGEND
        RIGHT_LEGEND
        TOP_LEGEND
        NO_LEGEND
        INSIDE_LEGEND],
       :showItemDividers boolean,
       :bucketSize number,
       :outlierPercentile number},
      :subtitle string,
      :fontName string,
      :bubbleChart
      {:bubbleBorderColor Color,
       :bubbleBorderColorStyle ColorStyle,
       :bubbleTextStyle TextFormat,
       :series ChartData,
       :legendPosition
       [BUBBLE_CHART_LEGEND_POSITION_UNSPECIFIED
        BOTTOM_LEGEND
        LEFT_LEGEND
        RIGHT_LEGEND
        TOP_LEGEND
        NO_LEGEND
        INSIDE_LEGEND],
       :bubbleLabels ChartData,
       :groupIds ChartData,
       :bubbleMinRadiusSize integer,
       :domain ChartData,
       :bubbleOpacity number,
       :bubbleMaxRadiusSize integer,
       :bubbleSizes ChartData},
      :hiddenDimensionStrategy
      [CHART_HIDDEN_DIMENSION_STRATEGY_UNSPECIFIED
       SKIP_HIDDEN_ROWS_AND_COLUMNS
       SKIP_HIDDEN_ROWS
       SKIP_HIDDEN_COLUMNS
       SHOW_ALL],
      :titleTextFormat
      {:bold boolean,
       :foregroundColorStyle ColorStyle,
       :underline boolean,
       :fontFamily string,
       :link Link,
       :strikethrough boolean,
       :fontSize integer,
       :italic boolean,
       :foregroundColor Color},
      :backgroundColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :treemapChart
      {:labels ChartData,
       :maxValue number,
       :headerColorStyle ColorStyle,
       :textFormat TextFormat,
       :parentLabels ChartData,
       :hideTooltips boolean,
       :minValue number,
       :levels integer,
       :colorData ChartData,
       :sizeData ChartData,
       :colorScale TreemapChartColorScale,
       :hintedLevels integer,
       :headerColor Color},
      :backgroundColor
      {:red number, :green number, :blue number, :alpha number},
      :orgChart
      {:nodeSize [ORG_CHART_LABEL_SIZE_UNSPECIFIED SMALL MEDIUM LARGE],
       :nodeColor Color,
       :nodeColorStyle ColorStyle,
       :selectedNodeColor Color,
       :selectedNodeColorStyle ColorStyle,
       :labels ChartData,
       :parentLabels ChartData,
       :tooltips ChartData}},
     :position
     {:sheetId integer,
      :overlayPosition
      {:anchorCell GridCoordinate,
       :offsetXPixels integer,
       :offsetYPixels integer,
       :widthPixels integer,
       :heightPixels integer},
      :newSheet boolean},
     :border
     {:color {:red number, :green number, :blue number, :alpha number},
      :colorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]}}}],
   :conditionalFormats
   [{:ranges
     [{:sheetId integer,
       :startRowIndex integer,
       :endRowIndex integer,
       :startColumnIndex integer,
       :endColumnIndex integer}],
     :booleanRule
     {:condition
      {:type
       [CONDITION_TYPE_UNSPECIFIED
        NUMBER_GREATER
        NUMBER_GREATER_THAN_EQ
        NUMBER_LESS
        NUMBER_LESS_THAN_EQ
        NUMBER_EQ
        NUMBER_NOT_EQ
        NUMBER_BETWEEN
        NUMBER_NOT_BETWEEN
        TEXT_CONTAINS
        TEXT_NOT_CONTAINS
        TEXT_STARTS_WITH
        TEXT_ENDS_WITH
        TEXT_EQ
        TEXT_IS_EMAIL
        TEXT_IS_URL
        DATE_EQ
        DATE_BEFORE
        DATE_AFTER
        DATE_ON_OR_BEFORE
        DATE_ON_OR_AFTER
        DATE_BETWEEN
        DATE_NOT_BETWEEN
        DATE_IS_VALID
        ONE_OF_RANGE
        ONE_OF_LIST
        BLANK
        NOT_BLANK
        CUSTOM_FORMULA
        BOOLEAN
        TEXT_NOT_EQ
        DATE_NOT_EQ
        FILTER_EXPRESSION],
       :values [ConditionValue]},
      :format
      {:textFormat TextFormat,
       :textRotation TextRotation,
       :textDirection
       [TEXT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT],
       :borders Borders,
       :numberFormat NumberFormat,
       :verticalAlignment
       [VERTICAL_ALIGN_UNSPECIFIED TOP MIDDLE BOTTOM],
       :hyperlinkDisplayType
       [HYPERLINK_DISPLAY_TYPE_UNSPECIFIED LINKED PLAIN_TEXT],
       :padding Padding,
       :wrapStrategy
       [WRAP_STRATEGY_UNSPECIFIED OVERFLOW_CELL LEGACY_WRAP CLIP WRAP],
       :backgroundColorStyle ColorStyle,
       :backgroundColor Color,
       :horizontalAlignment
       [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]}},
     :gradientRule
     {:minpoint
      {:color Color,
       :colorStyle ColorStyle,
       :type
       [INTERPOLATION_POINT_TYPE_UNSPECIFIED
        MIN
        MAX
        NUMBER
        PERCENT
        PERCENTILE],
       :value string},
      :midpoint
      {:color Color,
       :colorStyle ColorStyle,
       :type
       [INTERPOLATION_POINT_TYPE_UNSPECIFIED
        MIN
        MAX
        NUMBER
        PERCENT
        PERCENTILE],
       :value string},
      :maxpoint
      {:color Color,
       :colorStyle ColorStyle,
       :type
       [INTERPOLATION_POINT_TYPE_UNSPECIFIED
        MIN
        MAX
        NUMBER
        PERCENT
        PERCENTILE],
       :value string}}}],
   :data
   [{:startRow integer,
     :startColumn integer,
     :rowData
     [{:values
       [{:effectiveFormat CellFormat,
         :dataValidation DataValidationRule,
         :textFormatRuns [TextFormatRun],
         :effectiveValue ExtendedValue,
         :note string,
         :dataSourceFormula DataSourceFormula,
         :dataSourceTable DataSourceTable,
         :formattedValue string,
         :hyperlink string,
         :userEnteredValue ExtendedValue,
         :pivotTable PivotTable,
         :userEnteredFormat CellFormat}]}],
     :rowMetadata
     [{:hiddenByFilter boolean,
       :hiddenByUser boolean,
       :pixelSize integer,
       :developerMetadata
       [{:metadataId integer,
         :metadataKey string,
         :metadataValue string,
         :location DeveloperMetadataLocation,
         :visibility
         [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED
          DOCUMENT
          PROJECT]}],
       :dataSourceColumnReference {:name string}}],
     :columnMetadata
     [{:hiddenByFilter boolean,
       :hiddenByUser boolean,
       :pixelSize integer,
       :developerMetadata
       [{:metadataId integer,
         :metadataKey string,
         :metadataValue string,
         :location DeveloperMetadataLocation,
         :visibility
         [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED
          DOCUMENT
          PROJECT]}],
       :dataSourceColumnReference {:name string}}]}]}],
 :namedRanges
 [{:namedRangeId string,
   :name string,
   :range
   {:sheetId integer,
    :startRowIndex integer,
    :endRowIndex integer,
    :startColumnIndex integer,
    :endColumnIndex integer}}],
 :spreadsheetUrl string,
 :developerMetadata
 [{:metadataId integer,
   :metadataKey string,
   :metadataValue string,
   :location
   {:locationType
    [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
     ROW
     COLUMN
     SHEET
     SPREADSHEET],
    :spreadsheet boolean,
    :sheetId integer,
    :dimensionRange
    {:sheetId integer,
     :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
     :startIndex integer,
     :endIndex integer}},
   :visibility
   [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]}],
 :dataSources
 [{:dataSourceId string,
   :spec
   {:bigQuery
    {:projectId string,
     :querySpec {:rawQuery string},
     :tableSpec
     {:tableProjectId string, :tableId string, :datasetId string}},
    :parameters
    [{:name string,
      :namedRangeId string,
      :range
      {:sheetId integer,
       :startRowIndex integer,
       :endRowIndex integer,
       :startColumnIndex integer,
       :endColumnIndex integer}}]},
   :calculatedColumns [{:reference {:name string}, :formula string}],
   :sheetId integer}],
 :dataSourceSchedules
 [{:enabled boolean,
   :refreshScope
   [DATA_SOURCE_REFRESH_SCOPE_UNSPECIFIED ALL_DATA_SOURCES],
   :dailySchedule
   {:startTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer}},
   :weeklySchedule
   {:startTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer},
    :daysOfWeek
    [[DAY_OF_WEEK_UNSPECIFIED
      MONDAY
      TUESDAY
      WEDNESDAY
      THURSDAY
      FRIDAY
      SATURDAY
      SUNDAY]]},
   :monthlySchedule
   {:startTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer},
    :daysOfMonth [integer]},
   :nextRun {:startTime string, :endTime string}}]}"
  [Spreadsheet]
  (client/api-request
    {:method "POST",
     :uri-template "https://sheets.googleapis.com/v4/spreadsheets",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body Spreadsheet}))

(defn spreadsheets-get
  "Returns the spreadsheet at the given ID. The caller must specify the spreadsheet ID. By default, data within grids is not returned. You can include grid data in one of 2 ways: * Specify a [field mask](https://developers.google.com/sheets/api/guides/field-masks) listing your desired fields using the `fields` URL parameter in HTTP * Set the includeGridData URL parameter to true. If a field mask is set, the `includeGridData` parameter is ignored For large spreadsheets, as a best practice, retrieve only the specific spreadsheet fields that you want. To retrieve only subsets of spreadsheet data, use the ranges URL parameter. Ranges are specified using [A1 notation](/sheets/api/guides/concepts#cell). You can define a single cell (for example, `A1`) or multiple cells (for example, `A1:D5`). You can also get cells from other sheets within the same spreadsheet (for example, `Sheet2!A1:C4`) or retrieve multiple ranges at once (for example, `?ranges=A1:D5&ranges=Sheet2!A1:C4`). Limiting the range returns only the portions of the spreadsheet that intersect the requested ranges.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/get

spreadsheetId <string> The spreadsheet to request.

optional:
ranges <string> The ranges to retrieve from the spreadsheet.
includeGridData <boolean> True if grid data should be returned. This parameter is ignored if a field mask was set in the request."
  ([spreadsheetId] (spreadsheets-get spreadsheetId nil))
  ([spreadsheetId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}",
       :uri-template-args {:spreadsheetId spreadsheetId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.readonly"
        "https://www.googleapis.com/auth/spreadsheets"
        "https://www.googleapis.com/auth/spreadsheets.readonly"]})))

(defn spreadsheets-getByDataFilter
  "Returns the spreadsheet at the given ID. The caller must specify the spreadsheet ID. This method differs from GetSpreadsheet in that it allows selecting which subsets of spreadsheet data to return by specifying a dataFilters parameter. Multiple DataFilters can be specified. Specifying one or more data filters returns the portions of the spreadsheet that intersect ranges matched by any of the filters. By default, data within grids is not returned. You can include grid data one of 2 ways: * Specify a [field mask](https://developers.google.com/sheets/api/guides/field-masks) listing your desired fields using the `fields` URL parameter in HTTP * Set the includeGridData parameter to true. If a field mask is set, the `includeGridData` parameter is ignored For large spreadsheets, as a best practice, retrieve only the specific spreadsheet fields that you want.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/getByDataFilter

spreadsheetId <string> The spreadsheet to request.
GetSpreadsheetByDataFilterRequest:
{:dataFilters
 [{:developerMetadataLookup
   {:locationType
    [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
     ROW
     COLUMN
     SHEET
     SPREADSHEET],
    :metadataLocation
    {:locationType
     [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
      ROW
      COLUMN
      SHEET
      SPREADSHEET],
     :spreadsheet boolean,
     :sheetId integer,
     :dimensionRange
     {:sheetId integer,
      :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
      :startIndex integer,
      :endIndex integer}},
    :locationMatchingStrategy
    [DEVELOPER_METADATA_LOCATION_MATCHING_STRATEGY_UNSPECIFIED
     EXACT_LOCATION
     INTERSECTING_LOCATION],
    :metadataId integer,
    :metadataKey string,
    :metadataValue string,
    :visibility
    [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]},
   :a1Range string,
   :gridRange
   {:sheetId integer,
    :startRowIndex integer,
    :endRowIndex integer,
    :startColumnIndex integer,
    :endColumnIndex integer}}],
 :includeGridData boolean}"
  [spreadsheetId GetSpreadsheetByDataFilterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}:getByDataFilter",
     :uri-template-args {:spreadsheetId spreadsheetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body GetSpreadsheetByDataFilterRequest}))

(defn spreadsheets-batchUpdate
  "Applies one or more updates to the spreadsheet. Each request is validated before being applied. If any request is not valid then the entire request will fail and nothing will be applied. Some requests have replies to give you some information about how they are applied. The replies will mirror the requests. For example, if you applied 4 updates and the 3rd one had a reply, then the response will have 2 empty replies, the actual reply, and another empty reply, in that order. Due to the collaborative nature of spreadsheets, it is not guaranteed that the spreadsheet will reflect exactly your changes after this completes, however it is guaranteed that the updates in the request will be applied together atomically. Your changes may be altered with respect to collaborator changes. If there are no collaborators, the spreadsheet should reflect your changes.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/batchUpdate

spreadsheetId <string> The spreadsheet to apply the updates to.
BatchUpdateSpreadsheetRequest:
{:requests
 [{:moveDimension
   {:source
    {:sheetId integer,
     :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
     :startIndex integer,
     :endIndex integer},
    :destinationIndex integer},
   :repeatCell
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :cell
    {:effectiveFormat
     {:textFormat TextFormat,
      :textRotation TextRotation,
      :textDirection
      [TEXT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT],
      :borders Borders,
      :numberFormat NumberFormat,
      :verticalAlignment
      [VERTICAL_ALIGN_UNSPECIFIED TOP MIDDLE BOTTOM],
      :hyperlinkDisplayType
      [HYPERLINK_DISPLAY_TYPE_UNSPECIFIED LINKED PLAIN_TEXT],
      :padding Padding,
      :wrapStrategy
      [WRAP_STRATEGY_UNSPECIFIED OVERFLOW_CELL LEGACY_WRAP CLIP WRAP],
      :backgroundColorStyle ColorStyle,
      :backgroundColor Color,
      :horizontalAlignment
      [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
     :dataValidation
     {:condition BooleanCondition,
      :inputMessage string,
      :strict boolean,
      :showCustomUi boolean},
     :textFormatRuns [{:startIndex integer, :format TextFormat}],
     :effectiveValue
     {:numberValue number,
      :stringValue string,
      :boolValue boolean,
      :formulaValue string,
      :errorValue ErrorValue},
     :note string,
     :dataSourceFormula
     {:dataSourceId string, :dataExecutionStatus DataExecutionStatus},
     :dataSourceTable
     {:dataSourceId string,
      :columnSelectionType
      [DATA_SOURCE_TABLE_COLUMN_SELECTION_TYPE_UNSPECIFIED
       SELECTED
       SYNC_ALL],
      :columns [DataSourceColumnReference],
      :filterSpecs [FilterSpec],
      :sortSpecs [SortSpec],
      :rowLimit integer,
      :dataExecutionStatus DataExecutionStatus},
     :formattedValue string,
     :hyperlink string,
     :userEnteredValue
     {:numberValue number,
      :stringValue string,
      :boolValue boolean,
      :formulaValue string,
      :errorValue ErrorValue},
     :pivotTable
     {:filterSpecs [PivotFilterSpec],
      :columns [PivotGroup],
      :criteria object,
      :source GridRange,
      :rows [PivotGroup],
      :values [PivotValue],
      :dataSourceId string,
      :valueLayout [HORIZONTAL VERTICAL],
      :dataExecutionStatus DataExecutionStatus},
     :userEnteredFormat
     {:textFormat TextFormat,
      :textRotation TextRotation,
      :textDirection
      [TEXT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT],
      :borders Borders,
      :numberFormat NumberFormat,
      :verticalAlignment
      [VERTICAL_ALIGN_UNSPECIFIED TOP MIDDLE BOTTOM],
      :hyperlinkDisplayType
      [HYPERLINK_DISPLAY_TYPE_UNSPECIFIED LINKED PLAIN_TEXT],
      :padding Padding,
      :wrapStrategy
      [WRAP_STRATEGY_UNSPECIFIED OVERFLOW_CELL LEGACY_WRAP CLIP WRAP],
      :backgroundColorStyle ColorStyle,
      :backgroundColor Color,
      :horizontalAlignment
      [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]}},
    :fields string},
   :updateFilterView
   {:filter
    {:filterViewId integer,
     :title string,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :namedRangeId string,
     :sortSpecs
     [{:dimensionIndex integer,
       :dataSourceColumnReference DataSourceColumnReference,
       :sortOrder [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING],
       :foregroundColor Color,
       :foregroundColorStyle ColorStyle,
       :backgroundColor Color,
       :backgroundColorStyle ColorStyle}],
     :criteria object,
     :filterSpecs
     [{:columnIndex integer,
       :dataSourceColumnReference DataSourceColumnReference,
       :filterCriteria FilterCriteria}]},
    :fields string},
   :addSlicer
   {:slicer
    {:slicerId integer,
     :spec
     {:textFormat TextFormat,
      :dataRange GridRange,
      :filterCriteria FilterCriteria,
      :title string,
      :applyToPivotTables boolean,
      :columnIndex integer,
      :backgroundColorStyle ColorStyle,
      :backgroundColor Color,
      :horizontalAlignment
      [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
     :position
     {:sheetId integer,
      :overlayPosition OverlayPosition,
      :newSheet boolean}}},
   :deleteEmbeddedObject {:objectId integer},
   :deleteBanding {:bandedRangeId integer},
   :addDimensionGroup
   {:range
    {:sheetId integer,
     :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
     :startIndex integer,
     :endIndex integer}},
   :addConditionalFormatRule
   {:rule
    {:ranges
     [{:sheetId integer,
       :startRowIndex integer,
       :endRowIndex integer,
       :startColumnIndex integer,
       :endColumnIndex integer}],
     :booleanRule {:condition BooleanCondition, :format CellFormat},
     :gradientRule
     {:minpoint InterpolationPoint,
      :midpoint InterpolationPoint,
      :maxpoint InterpolationPoint}},
    :index integer},
   :updateDimensionGroup
   {:dimensionGroup
    {:range
     {:sheetId integer,
      :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
      :startIndex integer,
      :endIndex integer},
     :depth integer,
     :collapsed boolean},
    :fields string},
   :updateCells
   {:start {:sheetId integer, :rowIndex integer, :columnIndex integer},
    :range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :rows
    [{:values
      [{:effectiveFormat CellFormat,
        :dataValidation DataValidationRule,
        :textFormatRuns [TextFormatRun],
        :effectiveValue ExtendedValue,
        :note string,
        :dataSourceFormula DataSourceFormula,
        :dataSourceTable DataSourceTable,
        :formattedValue string,
        :hyperlink string,
        :userEnteredValue ExtendedValue,
        :pivotTable PivotTable,
        :userEnteredFormat CellFormat}]}],
    :fields string},
   :updateProtectedRange
   {:protectedRange
    {:protectedRangeId integer,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :namedRangeId string,
     :description string,
     :warningOnly boolean,
     :requestingUserCanEdit boolean,
     :unprotectedRanges
     [{:sheetId integer,
       :startRowIndex integer,
       :endRowIndex integer,
       :startColumnIndex integer,
       :endColumnIndex integer}],
     :editors
     {:users [string], :groups [string], :domainUsersCanEdit boolean}},
    :fields string},
   :addFilterView
   {:filter
    {:filterViewId integer,
     :title string,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :namedRangeId string,
     :sortSpecs
     [{:dimensionIndex integer,
       :dataSourceColumnReference DataSourceColumnReference,
       :sortOrder [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING],
       :foregroundColor Color,
       :foregroundColorStyle ColorStyle,
       :backgroundColor Color,
       :backgroundColorStyle ColorStyle}],
     :criteria object,
     :filterSpecs
     [{:columnIndex integer,
       :dataSourceColumnReference DataSourceColumnReference,
       :filterCriteria FilterCriteria}]}},
   :autoResizeDimensions
   {:dimensions
    {:sheetId integer,
     :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
     :startIndex integer,
     :endIndex integer},
    :dataSourceSheetDimensions
    {:sheetId integer, :columnReferences [{:name string}]}},
   :insertDimension
   {:range
    {:sheetId integer,
     :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
     :startIndex integer,
     :endIndex integer},
    :inheritFromBefore boolean},
   :addDataSource
   {:dataSource
    {:dataSourceId string,
     :spec
     {:bigQuery BigQueryDataSourceSpec,
      :parameters [DataSourceParameter]},
     :calculatedColumns
     [{:reference DataSourceColumnReference, :formula string}],
     :sheetId integer}},
   :updateChartSpec
   {:chartId integer,
    :spec
    {:subtitleTextFormat
     {:bold boolean,
      :foregroundColorStyle ColorStyle,
      :underline boolean,
      :fontFamily string,
      :link Link,
      :strikethrough boolean,
      :fontSize integer,
      :italic boolean,
      :foregroundColor Color},
     :titleTextPosition
     {:horizontalAlignment
      [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
     :pieChart
     {:legendPosition
      [PIE_CHART_LEGEND_POSITION_UNSPECIFIED
       BOTTOM_LEGEND
       LEFT_LEGEND
       RIGHT_LEGEND
       TOP_LEGEND
       NO_LEGEND
       LABELED_LEGEND],
      :domain ChartData,
      :series ChartData,
      :threeDimensional boolean,
      :pieHole number},
     :sortSpecs
     [{:dimensionIndex integer,
       :dataSourceColumnReference DataSourceColumnReference,
       :sortOrder [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING],
       :foregroundColor Color,
       :foregroundColorStyle ColorStyle,
       :backgroundColor Color,
       :backgroundColorStyle ColorStyle}],
     :candlestickChart
     {:domain CandlestickDomain, :data [CandlestickData]},
     :filterSpecs
     [{:columnIndex integer,
       :dataSourceColumnReference DataSourceColumnReference,
       :filterCriteria FilterCriteria}],
     :altText string,
     :dataSourceChartProperties
     {:dataSourceId string, :dataExecutionStatus DataExecutionStatus},
     :basicChart
     {:lineSmoothing boolean,
      :totalDataLabel DataLabel,
      :chartType
      [BASIC_CHART_TYPE_UNSPECIFIED
       BAR
       LINE
       AREA
       COLUMN
       SCATTER
       COMBO
       STEPPED_AREA],
      :series [BasicChartSeries],
      :domains [BasicChartDomain],
      :legendPosition
      [BASIC_CHART_LEGEND_POSITION_UNSPECIFIED
       BOTTOM_LEGEND
       LEFT_LEGEND
       RIGHT_LEGEND
       TOP_LEGEND
       NO_LEGEND],
      :threeDimensional boolean,
      :compareMode
      [BASIC_CHART_COMPARE_MODE_UNSPECIFIED DATUM CATEGORY],
      :interpolateNulls boolean,
      :axis [BasicChartAxis],
      :headerCount integer,
      :stackedType
      [BASIC_CHART_STACKED_TYPE_UNSPECIFIED
       NOT_STACKED
       STACKED
       PERCENT_STACKED]},
     :subtitleTextPosition
     {:horizontalAlignment
      [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
     :scorecardChart
     {:keyValueData ChartData,
      :baselineValueData ChartData,
      :aggregateType
      [CHART_AGGREGATE_TYPE_UNSPECIFIED
       AVERAGE
       COUNT
       MAX
       MEDIAN
       MIN
       SUM],
      :keyValueFormat KeyValueFormat,
      :baselineValueFormat BaselineValueFormat,
      :scaleFactor number,
      :numberFormatSource
      [CHART_NUMBER_FORMAT_SOURCE_UNDEFINED FROM_DATA CUSTOM],
      :customFormatOptions ChartCustomNumberFormatOptions},
     :waterfallChart
     {:domain WaterfallChartDomain,
      :series [WaterfallChartSeries],
      :stackedType
      [WATERFALL_STACKED_TYPE_UNSPECIFIED STACKED SEQUENTIAL],
      :firstValueIsTotal boolean,
      :hideConnectorLines boolean,
      :connectorLineStyle LineStyle,
      :totalDataLabel DataLabel},
     :maximized boolean,
     :title string,
     :histogramChart
     {:series [HistogramSeries],
      :legendPosition
      [HISTOGRAM_CHART_LEGEND_POSITION_UNSPECIFIED
       BOTTOM_LEGEND
       LEFT_LEGEND
       RIGHT_LEGEND
       TOP_LEGEND
       NO_LEGEND
       INSIDE_LEGEND],
      :showItemDividers boolean,
      :bucketSize number,
      :outlierPercentile number},
     :subtitle string,
     :fontName string,
     :bubbleChart
     {:bubbleBorderColor Color,
      :bubbleBorderColorStyle ColorStyle,
      :bubbleTextStyle TextFormat,
      :series ChartData,
      :legendPosition
      [BUBBLE_CHART_LEGEND_POSITION_UNSPECIFIED
       BOTTOM_LEGEND
       LEFT_LEGEND
       RIGHT_LEGEND
       TOP_LEGEND
       NO_LEGEND
       INSIDE_LEGEND],
      :bubbleLabels ChartData,
      :groupIds ChartData,
      :bubbleMinRadiusSize integer,
      :domain ChartData,
      :bubbleOpacity number,
      :bubbleMaxRadiusSize integer,
      :bubbleSizes ChartData},
     :hiddenDimensionStrategy
     [CHART_HIDDEN_DIMENSION_STRATEGY_UNSPECIFIED
      SKIP_HIDDEN_ROWS_AND_COLUMNS
      SKIP_HIDDEN_ROWS
      SKIP_HIDDEN_COLUMNS
      SHOW_ALL],
     :titleTextFormat
     {:bold boolean,
      :foregroundColorStyle ColorStyle,
      :underline boolean,
      :fontFamily string,
      :link Link,
      :strikethrough boolean,
      :fontSize integer,
      :italic boolean,
      :foregroundColor Color},
     :backgroundColorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]},
     :treemapChart
     {:labels ChartData,
      :maxValue number,
      :headerColorStyle ColorStyle,
      :textFormat TextFormat,
      :parentLabels ChartData,
      :hideTooltips boolean,
      :minValue number,
      :levels integer,
      :colorData ChartData,
      :sizeData ChartData,
      :colorScale TreemapChartColorScale,
      :hintedLevels integer,
      :headerColor Color},
     :backgroundColor
     {:red number, :green number, :blue number, :alpha number},
     :orgChart
     {:nodeSize [ORG_CHART_LABEL_SIZE_UNSPECIFIED SMALL MEDIUM LARGE],
      :nodeColor Color,
      :nodeColorStyle ColorStyle,
      :selectedNodeColor Color,
      :selectedNodeColorStyle ColorStyle,
      :labels ChartData,
      :parentLabels ChartData,
      :tooltips ChartData}}},
   :duplicateSheet
   {:sourceSheetId integer,
    :insertSheetIndex integer,
    :newSheetId integer,
    :newSheetName string},
   :trimWhitespace
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer}},
   :pasteData
   {:coordinate
    {:sheetId integer, :rowIndex integer, :columnIndex integer},
    :data string,
    :delimiter string,
    :html boolean,
    :type
    [PASTE_NORMAL
     PASTE_VALUES
     PASTE_FORMAT
     PASTE_NO_BORDERS
     PASTE_FORMULA
     PASTE_DATA_VALIDATION
     PASTE_CONDITIONAL_FORMATTING]},
   :deleteDataSource {:dataSourceId string},
   :updateSpreadsheetProperties
   {:properties
    {:title string,
     :locale string,
     :autoRecalc
     [RECALCULATION_INTERVAL_UNSPECIFIED ON_CHANGE MINUTE HOUR],
     :timeZone string,
     :defaultFormat
     {:textFormat TextFormat,
      :textRotation TextRotation,
      :textDirection
      [TEXT_DIRECTION_UNSPECIFIED LEFT_TO_RIGHT RIGHT_TO_LEFT],
      :borders Borders,
      :numberFormat NumberFormat,
      :verticalAlignment
      [VERTICAL_ALIGN_UNSPECIFIED TOP MIDDLE BOTTOM],
      :hyperlinkDisplayType
      [HYPERLINK_DISPLAY_TYPE_UNSPECIFIED LINKED PLAIN_TEXT],
      :padding Padding,
      :wrapStrategy
      [WRAP_STRATEGY_UNSPECIFIED OVERFLOW_CELL LEGACY_WRAP CLIP WRAP],
      :backgroundColorStyle ColorStyle,
      :backgroundColor Color,
      :horizontalAlignment
      [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
     :iterativeCalculationSettings
     {:maxIterations integer, :convergenceThreshold number},
     :spreadsheetTheme
     {:primaryFontFamily string, :themeColors [ThemeColorPair]},
     :importFunctionsExternalUrlAccessAllowed boolean},
    :fields string},
   :addBanding
   {:bandedRange
    {:bandedRangeId integer,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :rowProperties
     {:headerColor Color,
      :headerColorStyle ColorStyle,
      :firstBandColor Color,
      :firstBandColorStyle ColorStyle,
      :secondBandColor Color,
      :secondBandColorStyle ColorStyle,
      :footerColor Color,
      :footerColorStyle ColorStyle},
     :columnProperties
     {:headerColor Color,
      :headerColorStyle ColorStyle,
      :firstBandColor Color,
      :firstBandColorStyle ColorStyle,
      :secondBandColor Color,
      :secondBandColorStyle ColorStyle,
      :footerColor Color,
      :footerColorStyle ColorStyle}}},
   :updateBanding
   {:bandedRange
    {:bandedRangeId integer,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :rowProperties
     {:headerColor Color,
      :headerColorStyle ColorStyle,
      :firstBandColor Color,
      :firstBandColorStyle ColorStyle,
      :secondBandColor Color,
      :secondBandColorStyle ColorStyle,
      :footerColor Color,
      :footerColorStyle ColorStyle},
     :columnProperties
     {:headerColor Color,
      :headerColorStyle ColorStyle,
      :firstBandColor Color,
      :firstBandColorStyle ColorStyle,
      :secondBandColor Color,
      :secondBandColorStyle ColorStyle,
      :footerColor Color,
      :footerColorStyle ColorStyle}},
    :fields string},
   :deleteDuplicates
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :comparisonColumns
    [{:sheetId integer,
      :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
      :startIndex integer,
      :endIndex integer}]},
   :deleteSheet {:sheetId integer},
   :deleteProtectedRange {:protectedRangeId integer},
   :cancelDataSourceRefresh
   {:references
    {:references
     [{:sheetId string,
       :chartId integer,
       :dataSourceTableAnchorCell GridCoordinate,
       :dataSourcePivotTableAnchorCell GridCoordinate,
       :dataSourceFormulaCell GridCoordinate}]},
    :dataSourceId string,
    :isAll boolean},
   :updateDeveloperMetadata
   {:dataFilters
    [{:developerMetadataLookup
      {:locationType
       [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
        ROW
        COLUMN
        SHEET
        SPREADSHEET],
       :metadataLocation DeveloperMetadataLocation,
       :locationMatchingStrategy
       [DEVELOPER_METADATA_LOCATION_MATCHING_STRATEGY_UNSPECIFIED
        EXACT_LOCATION
        INTERSECTING_LOCATION],
       :metadataId integer,
       :metadataKey string,
       :metadataValue string,
       :visibility
       [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]},
      :a1Range string,
      :gridRange
      {:sheetId integer,
       :startRowIndex integer,
       :endRowIndex integer,
       :startColumnIndex integer,
       :endColumnIndex integer}}],
    :developerMetadata
    {:metadataId integer,
     :metadataKey string,
     :metadataValue string,
     :location
     {:locationType
      [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
       ROW
       COLUMN
       SHEET
       SPREADSHEET],
      :spreadsheet boolean,
      :sheetId integer,
      :dimensionRange DimensionRange},
     :visibility
     [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]},
    :fields string},
   :updateSheetProperties
   {:properties
    {:tabColor
     {:red number, :green number, :blue number, :alpha number},
     :sheetId integer,
     :index integer,
     :tabColorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]},
     :dataSourceSheetProperties
     {:dataSourceId string,
      :columns [DataSourceColumn],
      :dataExecutionStatus DataExecutionStatus},
     :rightToLeft boolean,
     :title string,
     :hidden boolean,
     :sheetType [SHEET_TYPE_UNSPECIFIED GRID OBJECT DATA_SOURCE],
     :gridProperties
     {:rowCount integer,
      :columnCount integer,
      :frozenRowCount integer,
      :frozenColumnCount integer,
      :hideGridlines boolean,
      :rowGroupControlAfter boolean,
      :columnGroupControlAfter boolean}},
    :fields string},
   :duplicateFilterView {:filterId integer},
   :updateDimensionProperties
   {:range
    {:sheetId integer,
     :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
     :startIndex integer,
     :endIndex integer},
    :dataSourceSheetRange
    {:sheetId integer, :columnReferences [{:name string}]},
    :properties
    {:hiddenByFilter boolean,
     :hiddenByUser boolean,
     :pixelSize integer,
     :developerMetadata
     [{:metadataId integer,
       :metadataKey string,
       :metadataValue string,
       :location DeveloperMetadataLocation,
       :visibility
       [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]}],
     :dataSourceColumnReference {:name string}},
    :fields string},
   :deleteDeveloperMetadata
   {:dataFilter
    {:developerMetadataLookup
     {:locationType
      [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
       ROW
       COLUMN
       SHEET
       SPREADSHEET],
      :metadataLocation DeveloperMetadataLocation,
      :locationMatchingStrategy
      [DEVELOPER_METADATA_LOCATION_MATCHING_STRATEGY_UNSPECIFIED
       EXACT_LOCATION
       INTERSECTING_LOCATION],
      :metadataId integer,
      :metadataKey string,
      :metadataValue string,
      :visibility
      [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]},
     :a1Range string,
     :gridRange
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer}}},
   :unmergeCells
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer}},
   :createDeveloperMetadata
   {:developerMetadata
    {:metadataId integer,
     :metadataKey string,
     :metadataValue string,
     :location
     {:locationType
      [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
       ROW
       COLUMN
       SHEET
       SPREADSHEET],
      :spreadsheet boolean,
      :sheetId integer,
      :dimensionRange DimensionRange},
     :visibility
     [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]}},
   :updateDataSource
   {:dataSource
    {:dataSourceId string,
     :spec
     {:bigQuery BigQueryDataSourceSpec,
      :parameters [DataSourceParameter]},
     :calculatedColumns
     [{:reference DataSourceColumnReference, :formula string}],
     :sheetId integer},
    :fields string},
   :updateEmbeddedObjectBorder
   {:objectId integer,
    :border
    {:color {:red number, :green number, :blue number, :alpha number},
     :colorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]}},
    :fields string},
   :cutPaste
   {:source
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :destination
    {:sheetId integer, :rowIndex integer, :columnIndex integer},
    :pasteType
    [PASTE_NORMAL
     PASTE_VALUES
     PASTE_FORMAT
     PASTE_NO_BORDERS
     PASTE_FORMULA
     PASTE_DATA_VALIDATION
     PASTE_CONDITIONAL_FORMATTING]},
   :appendDimension
   {:sheetId integer,
    :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
    :length integer},
   :deleteFilterView {:filterId integer},
   :deleteRange
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :shiftDimension [DIMENSION_UNSPECIFIED ROWS COLUMNS]},
   :setDataValidation
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :rule
    {:condition
     {:type
      [CONDITION_TYPE_UNSPECIFIED
       NUMBER_GREATER
       NUMBER_GREATER_THAN_EQ
       NUMBER_LESS
       NUMBER_LESS_THAN_EQ
       NUMBER_EQ
       NUMBER_NOT_EQ
       NUMBER_BETWEEN
       NUMBER_NOT_BETWEEN
       TEXT_CONTAINS
       TEXT_NOT_CONTAINS
       TEXT_STARTS_WITH
       TEXT_ENDS_WITH
       TEXT_EQ
       TEXT_IS_EMAIL
       TEXT_IS_URL
       DATE_EQ
       DATE_BEFORE
       DATE_AFTER
       DATE_ON_OR_BEFORE
       DATE_ON_OR_AFTER
       DATE_BETWEEN
       DATE_NOT_BETWEEN
       DATE_IS_VALID
       ONE_OF_RANGE
       ONE_OF_LIST
       BLANK
       NOT_BLANK
       CUSTOM_FORMULA
       BOOLEAN
       TEXT_NOT_EQ
       DATE_NOT_EQ
       FILTER_EXPRESSION],
      :values [ConditionValue]},
     :inputMessage string,
     :strict boolean,
     :showCustomUi boolean}},
   :deleteConditionalFormatRule {:index integer, :sheetId integer},
   :refreshDataSource
   {:references
    {:references
     [{:sheetId string,
       :chartId integer,
       :dataSourceTableAnchorCell GridCoordinate,
       :dataSourcePivotTableAnchorCell GridCoordinate,
       :dataSourceFormulaCell GridCoordinate}]},
    :dataSourceId string,
    :isAll boolean,
    :force boolean},
   :appendCells
   {:sheetId integer,
    :rows
    [{:values
      [{:effectiveFormat CellFormat,
        :dataValidation DataValidationRule,
        :textFormatRuns [TextFormatRun],
        :effectiveValue ExtendedValue,
        :note string,
        :dataSourceFormula DataSourceFormula,
        :dataSourceTable DataSourceTable,
        :formattedValue string,
        :hyperlink string,
        :userEnteredValue ExtendedValue,
        :pivotTable PivotTable,
        :userEnteredFormat CellFormat}]}],
    :fields string},
   :textToColumns
   {:source
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :delimiter string,
    :delimiterType
    [DELIMITER_TYPE_UNSPECIFIED
     COMMA
     SEMICOLON
     PERIOD
     SPACE
     CUSTOM
     AUTODETECT]},
   :deleteDimensionGroup
   {:range
    {:sheetId integer,
     :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
     :startIndex integer,
     :endIndex integer}},
   :mergeCells
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :mergeType [MERGE_ALL MERGE_COLUMNS MERGE_ROWS]},
   :randomizeRange
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer}},
   :insertRange
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :shiftDimension [DIMENSION_UNSPECIFIED ROWS COLUMNS]},
   :deleteNamedRange {:namedRangeId string},
   :updateNamedRange
   {:namedRange
    {:namedRangeId string,
     :name string,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer}},
    :fields string},
   :findReplace
   {:find string,
    :includeFormulas boolean,
    :matchEntireCell boolean,
    :sheetId integer,
    :replacement string,
    :matchCase boolean,
    :allSheets boolean,
    :searchByRegex boolean,
    :range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer}},
   :updateEmbeddedObjectPosition
   {:objectId integer,
    :newPosition
    {:sheetId integer,
     :overlayPosition
     {:anchorCell GridCoordinate,
      :offsetXPixels integer,
      :offsetYPixels integer,
      :widthPixels integer,
      :heightPixels integer},
     :newSheet boolean},
    :fields string},
   :addSheet
   {:properties
    {:tabColor
     {:red number, :green number, :blue number, :alpha number},
     :sheetId integer,
     :index integer,
     :tabColorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]},
     :dataSourceSheetProperties
     {:dataSourceId string,
      :columns [DataSourceColumn],
      :dataExecutionStatus DataExecutionStatus},
     :rightToLeft boolean,
     :title string,
     :hidden boolean,
     :sheetType [SHEET_TYPE_UNSPECIFIED GRID OBJECT DATA_SOURCE],
     :gridProperties
     {:rowCount integer,
      :columnCount integer,
      :frozenRowCount integer,
      :frozenColumnCount integer,
      :hideGridlines boolean,
      :rowGroupControlAfter boolean,
      :columnGroupControlAfter boolean}}},
   :updateBorders
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :top
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color {:red number, :green number, :blue number, :alpha number},
     :colorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]}},
    :bottom
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color {:red number, :green number, :blue number, :alpha number},
     :colorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]}},
    :left
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color {:red number, :green number, :blue number, :alpha number},
     :colorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]}},
    :right
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color {:red number, :green number, :blue number, :alpha number},
     :colorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]}},
    :innerHorizontal
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color {:red number, :green number, :blue number, :alpha number},
     :colorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]}},
    :innerVertical
    {:style
     [STYLE_UNSPECIFIED
      DOTTED
      DASHED
      SOLID
      SOLID_MEDIUM
      SOLID_THICK
      NONE
      DOUBLE],
     :width integer,
     :color {:red number, :green number, :blue number, :alpha number},
     :colorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]}}},
   :addNamedRange
   {:namedRange
    {:namedRangeId string,
     :name string,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer}}},
   :addChart
   {:chart
    {:chartId integer,
     :spec
     {:subtitleTextFormat TextFormat,
      :titleTextPosition TextPosition,
      :pieChart PieChartSpec,
      :sortSpecs [SortSpec],
      :candlestickChart CandlestickChartSpec,
      :filterSpecs [FilterSpec],
      :altText string,
      :dataSourceChartProperties DataSourceChartProperties,
      :basicChart BasicChartSpec,
      :subtitleTextPosition TextPosition,
      :scorecardChart ScorecardChartSpec,
      :waterfallChart WaterfallChartSpec,
      :maximized boolean,
      :title string,
      :histogramChart HistogramChartSpec,
      :subtitle string,
      :fontName string,
      :bubbleChart BubbleChartSpec,
      :hiddenDimensionStrategy
      [CHART_HIDDEN_DIMENSION_STRATEGY_UNSPECIFIED
       SKIP_HIDDEN_ROWS_AND_COLUMNS
       SKIP_HIDDEN_ROWS
       SKIP_HIDDEN_COLUMNS
       SHOW_ALL],
      :titleTextFormat TextFormat,
      :backgroundColorStyle ColorStyle,
      :treemapChart TreemapChartSpec,
      :backgroundColor Color,
      :orgChart OrgChartSpec},
     :position
     {:sheetId integer,
      :overlayPosition OverlayPosition,
      :newSheet boolean},
     :border {:color Color, :colorStyle ColorStyle}}},
   :addProtectedRange
   {:protectedRange
    {:protectedRangeId integer,
     :range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :namedRangeId string,
     :description string,
     :warningOnly boolean,
     :requestingUserCanEdit boolean,
     :unprotectedRanges
     [{:sheetId integer,
       :startRowIndex integer,
       :endRowIndex integer,
       :startColumnIndex integer,
       :endColumnIndex integer}],
     :editors
     {:users [string],
      :groups [string],
      :domainUsersCanEdit boolean}}},
   :setBasicFilter
   {:filter
    {:range
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :sortSpecs
     [{:dimensionIndex integer,
       :dataSourceColumnReference DataSourceColumnReference,
       :sortOrder [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING],
       :foregroundColor Color,
       :foregroundColorStyle ColorStyle,
       :backgroundColor Color,
       :backgroundColorStyle ColorStyle}],
     :criteria object,
     :filterSpecs
     [{:columnIndex integer,
       :dataSourceColumnReference DataSourceColumnReference,
       :filterCriteria FilterCriteria}]}},
   :clearBasicFilter {:sheetId integer},
   :sortRange
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :sortSpecs
    [{:dimensionIndex integer,
      :dataSourceColumnReference {:name string},
      :sortOrder [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING],
      :foregroundColor
      {:red number, :green number, :blue number, :alpha number},
      :foregroundColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]},
      :backgroundColor
      {:red number, :green number, :blue number, :alpha number},
      :backgroundColorStyle
      {:rgbColor Color,
       :themeColor
       [THEME_COLOR_TYPE_UNSPECIFIED
        TEXT
        BACKGROUND
        ACCENT1
        ACCENT2
        ACCENT3
        ACCENT4
        ACCENT5
        ACCENT6
        LINK]}}]},
   :deleteDimension
   {:range
    {:sheetId integer,
     :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
     :startIndex integer,
     :endIndex integer}},
   :updateSlicerSpec
   {:slicerId integer,
    :spec
    {:textFormat
     {:bold boolean,
      :foregroundColorStyle ColorStyle,
      :underline boolean,
      :fontFamily string,
      :link Link,
      :strikethrough boolean,
      :fontSize integer,
      :italic boolean,
      :foregroundColor Color},
     :dataRange
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :filterCriteria
     {:hiddenValues [string],
      :condition BooleanCondition,
      :visibleBackgroundColor Color,
      :visibleBackgroundColorStyle ColorStyle,
      :visibleForegroundColor Color,
      :visibleForegroundColorStyle ColorStyle},
     :title string,
     :applyToPivotTables boolean,
     :columnIndex integer,
     :backgroundColorStyle
     {:rgbColor Color,
      :themeColor
      [THEME_COLOR_TYPE_UNSPECIFIED
       TEXT
       BACKGROUND
       ACCENT1
       ACCENT2
       ACCENT3
       ACCENT4
       ACCENT5
       ACCENT6
       LINK]},
     :backgroundColor
     {:red number, :green number, :blue number, :alpha number},
     :horizontalAlignment
     [HORIZONTAL_ALIGN_UNSPECIFIED LEFT CENTER RIGHT]},
    :fields string},
   :autoFill
   {:range
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :sourceAndDestination
    {:source
     {:sheetId integer,
      :startRowIndex integer,
      :endRowIndex integer,
      :startColumnIndex integer,
      :endColumnIndex integer},
     :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
     :fillLength integer},
    :useAlternateSeries boolean},
   :copyPaste
   {:source
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :destination
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer},
    :pasteType
    [PASTE_NORMAL
     PASTE_VALUES
     PASTE_FORMAT
     PASTE_NO_BORDERS
     PASTE_FORMULA
     PASTE_DATA_VALIDATION
     PASTE_CONDITIONAL_FORMATTING],
    :pasteOrientation [NORMAL TRANSPOSE]},
   :updateConditionalFormatRule
   {:rule
    {:ranges
     [{:sheetId integer,
       :startRowIndex integer,
       :endRowIndex integer,
       :startColumnIndex integer,
       :endColumnIndex integer}],
     :booleanRule {:condition BooleanCondition, :format CellFormat},
     :gradientRule
     {:minpoint InterpolationPoint,
      :midpoint InterpolationPoint,
      :maxpoint InterpolationPoint}},
    :newIndex integer,
    :index integer,
    :sheetId integer}}],
 :includeSpreadsheetInResponse boolean,
 :responseRanges [string],
 :responseIncludeGridData boolean}"
  [spreadsheetId BatchUpdateSpreadsheetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}:batchUpdate",
     :uri-template-args {:spreadsheetId spreadsheetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body BatchUpdateSpreadsheetRequest}))

(defn spreadsheets-values-batchGetByDataFilter
  "Returns one or more ranges of values that match the specified data filters. The caller must specify the spreadsheet ID and one or more DataFilters. Ranges that match any of the data filters in the request will be returned.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/batchGetByDataFilter

spreadsheetId <string> The ID of the spreadsheet to retrieve data from.
BatchGetValuesByDataFilterRequest:
{:dataFilters
 [{:developerMetadataLookup
   {:locationType
    [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
     ROW
     COLUMN
     SHEET
     SPREADSHEET],
    :metadataLocation
    {:locationType
     [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
      ROW
      COLUMN
      SHEET
      SPREADSHEET],
     :spreadsheet boolean,
     :sheetId integer,
     :dimensionRange
     {:sheetId integer,
      :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
      :startIndex integer,
      :endIndex integer}},
    :locationMatchingStrategy
    [DEVELOPER_METADATA_LOCATION_MATCHING_STRATEGY_UNSPECIFIED
     EXACT_LOCATION
     INTERSECTING_LOCATION],
    :metadataId integer,
    :metadataKey string,
    :metadataValue string,
    :visibility
    [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]},
   :a1Range string,
   :gridRange
   {:sheetId integer,
    :startRowIndex integer,
    :endRowIndex integer,
    :startColumnIndex integer,
    :endColumnIndex integer}}],
 :majorDimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
 :valueRenderOption [FORMATTED_VALUE UNFORMATTED_VALUE FORMULA],
 :dateTimeRenderOption [SERIAL_NUMBER FORMATTED_STRING]}"
  [spreadsheetId BatchGetValuesByDataFilterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values:batchGetByDataFilter",
     :uri-template-args {:spreadsheetId spreadsheetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body BatchGetValuesByDataFilterRequest}))

(defn spreadsheets-values-get
  "Returns a range of values from a spreadsheet. The caller must specify the spreadsheet ID and a range.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/get

spreadsheetId <string> The ID of the spreadsheet to retrieve data from.
range <string> The [A1 notation or R1C1 notation](/sheets/api/guides/concepts#cell) of the range to retrieve values from.

optional:
majorDimension <string> The major dimension that results should use. For example, if the spreadsheet data in Sheet1 is: `A1=1,B1=2,A2=3,B2=4`, then requesting `range=Sheet1!A1:B2?majorDimension=ROWS` returns `[[1,2],[3,4]]`, whereas requesting `range=Sheet1!A1:B2?majorDimension=COLUMNS` returns `[[1,3],[2,4]]`.
valueRenderOption <string> How values should be represented in the output. The default render option is FORMATTED_VALUE.
dateTimeRenderOption <string> How dates, times, and durations should be represented in the output. This is ignored if value_render_option is FORMATTED_VALUE. The default dateTime render option is SERIAL_NUMBER."
  ([spreadsheetId range]
    (spreadsheets-values-get spreadsheetId range nil))
  ([spreadsheetId range optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values/{range}",
       :uri-template-args {:spreadsheetId spreadsheetId, :range range},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.readonly"
        "https://www.googleapis.com/auth/spreadsheets"
        "https://www.googleapis.com/auth/spreadsheets.readonly"]})))

(defn spreadsheets-values-batchUpdate
  "Sets values in one or more ranges of a spreadsheet. The caller must specify the spreadsheet ID, a valueInputOption, and one or more ValueRanges.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/batchUpdate

spreadsheetId <string> The ID of the spreadsheet to update.
BatchUpdateValuesRequest:
{:valueInputOption [INPUT_VALUE_OPTION_UNSPECIFIED RAW USER_ENTERED],
 :data
 [{:range string,
   :majorDimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
   :values [[any]]}],
 :includeValuesInResponse boolean,
 :responseValueRenderOption
 [FORMATTED_VALUE UNFORMATTED_VALUE FORMULA],
 :responseDateTimeRenderOption [SERIAL_NUMBER FORMATTED_STRING]}"
  [spreadsheetId BatchUpdateValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values:batchUpdate",
     :uri-template-args {:spreadsheetId spreadsheetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body BatchUpdateValuesRequest}))

(defn spreadsheets-values-batchGet
  "Returns one or more ranges of values from a spreadsheet. The caller must specify the spreadsheet ID and one or more ranges.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/batchGet

spreadsheetId <string> The ID of the spreadsheet to retrieve data from.

optional:
ranges <string> The [A1 notation or R1C1 notation](/sheets/api/guides/concepts#cell) of the range to retrieve values from.
majorDimension <string> The major dimension that results should use. For example, if the spreadsheet data is: `A1=1,B1=2,A2=3,B2=4`, then requesting `ranges=[\"A1:B2\"],majorDimension=ROWS` returns `[[1,2],[3,4]]`, whereas requesting `ranges=[\"A1:B2\"],majorDimension=COLUMNS` returns `[[1,3],[2,4]]`.
valueRenderOption <string> How values should be represented in the output. The default render option is ValueRenderOption.FORMATTED_VALUE.
dateTimeRenderOption <string> How dates, times, and durations should be represented in the output. This is ignored if value_render_option is FORMATTED_VALUE. The default dateTime render option is SERIAL_NUMBER."
  ([spreadsheetId] (spreadsheets-values-batchGet spreadsheetId nil))
  ([spreadsheetId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values:batchGet",
       :uri-template-args {:spreadsheetId spreadsheetId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.readonly"
        "https://www.googleapis.com/auth/spreadsheets"
        "https://www.googleapis.com/auth/spreadsheets.readonly"]})))

(defn spreadsheets-values-batchClearByDataFilter
  "Clears one or more ranges of values from a spreadsheet. The caller must specify the spreadsheet ID and one or more DataFilters. Ranges matching any of the specified data filters will be cleared. Only values are cleared -- all other properties of the cell (such as formatting, data validation, etc..) are kept.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/batchClearByDataFilter

spreadsheetId <string> The ID of the spreadsheet to update.
BatchClearValuesByDataFilterRequest:
{:dataFilters
 [{:developerMetadataLookup
   {:locationType
    [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
     ROW
     COLUMN
     SHEET
     SPREADSHEET],
    :metadataLocation
    {:locationType
     [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
      ROW
      COLUMN
      SHEET
      SPREADSHEET],
     :spreadsheet boolean,
     :sheetId integer,
     :dimensionRange
     {:sheetId integer,
      :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
      :startIndex integer,
      :endIndex integer}},
    :locationMatchingStrategy
    [DEVELOPER_METADATA_LOCATION_MATCHING_STRATEGY_UNSPECIFIED
     EXACT_LOCATION
     INTERSECTING_LOCATION],
    :metadataId integer,
    :metadataKey string,
    :metadataValue string,
    :visibility
    [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]},
   :a1Range string,
   :gridRange
   {:sheetId integer,
    :startRowIndex integer,
    :endRowIndex integer,
    :startColumnIndex integer,
    :endColumnIndex integer}}]}"
  [spreadsheetId BatchClearValuesByDataFilterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values:batchClearByDataFilter",
     :uri-template-args {:spreadsheetId spreadsheetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body BatchClearValuesByDataFilterRequest}))

(defn spreadsheets-values-append
  "Appends values to a spreadsheet. The input range is used to search for existing data and find a \"table\" within that range. Values will be appended to the next row of the table, starting with the first column of the table. See the [guide](/sheets/api/guides/values#appending_values) and [sample code](/sheets/api/samples/writing#append_values) for specific details of how tables are detected and data is appended. The caller must specify the spreadsheet ID, range, and a valueInputOption. The `valueInputOption` only controls how the input data will be added to the sheet (column-wise or row-wise), it does not influence what cell the data starts being written to.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/append

spreadsheetId <string> The ID of the spreadsheet to update.
range <string> The [A1 notation](/sheets/api/guides/concepts#cell) of a range to search for a logical table of data. Values are appended after the last row of the table.
ValueRange:
{:range string,
 :majorDimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
 :values [[any]]}

optional:
valueInputOption <string> How the input data should be interpreted.
insertDataOption <string> How the input data should be inserted.
includeValuesInResponse <boolean> Determines if the update response should include the values of the cells that were appended. By default, responses do not include the updated values.
responseValueRenderOption <string> Determines how values in the response should be rendered. The default render option is FORMATTED_VALUE.
responseDateTimeRenderOption <string> Determines how dates, times, and durations in the response should be rendered. This is ignored if response_value_render_option is FORMATTED_VALUE. The default dateTime render option is SERIAL_NUMBER."
  ([spreadsheetId range ValueRange]
    (spreadsheets-values-append spreadsheetId range ValueRange nil))
  ([spreadsheetId range ValueRange optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values/{range}:append",
       :uri-template-args {:spreadsheetId spreadsheetId, :range range},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/spreadsheets"],
       :body ValueRange})))

(defn spreadsheets-values-update
  "Sets values in a range of a spreadsheet. The caller must specify the spreadsheet ID, range, and a valueInputOption.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/update

spreadsheetId <string> The ID of the spreadsheet to update.
range <string> The [A1 notation](/sheets/api/guides/concepts#cell) of the values to update.
ValueRange:
{:range string,
 :majorDimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
 :values [[any]]}

optional:
valueInputOption <string> How the input data should be interpreted.
includeValuesInResponse <boolean> Determines if the update response should include the values of the cells that were updated. By default, responses do not include the updated values. If the range to write was larger than the range actually written, the response includes all values in the requested range (excluding trailing empty rows and columns).
responseValueRenderOption <string> Determines how values in the response should be rendered. The default render option is FORMATTED_VALUE.
responseDateTimeRenderOption <string> Determines how dates, times, and durations in the response should be rendered. This is ignored if response_value_render_option is FORMATTED_VALUE. The default dateTime render option is SERIAL_NUMBER."
  ([spreadsheetId range ValueRange]
    (spreadsheets-values-update spreadsheetId range ValueRange nil))
  ([spreadsheetId range ValueRange optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values/{range}",
       :uri-template-args {:spreadsheetId spreadsheetId, :range range},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/spreadsheets"],
       :body ValueRange})))

(defn spreadsheets-values-batchUpdateByDataFilter
  "Sets values in one or more ranges of a spreadsheet. The caller must specify the spreadsheet ID, a valueInputOption, and one or more DataFilterValueRanges.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/batchUpdateByDataFilter

spreadsheetId <string> The ID of the spreadsheet to update.
BatchUpdateValuesByDataFilterRequest:
{:valueInputOption [INPUT_VALUE_OPTION_UNSPECIFIED RAW USER_ENTERED],
 :data
 [{:dataFilter
   {:developerMetadataLookup
    {:locationType
     [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
      ROW
      COLUMN
      SHEET
      SPREADSHEET],
     :metadataLocation
     {:locationType
      [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
       ROW
       COLUMN
       SHEET
       SPREADSHEET],
      :spreadsheet boolean,
      :sheetId integer,
      :dimensionRange DimensionRange},
     :locationMatchingStrategy
     [DEVELOPER_METADATA_LOCATION_MATCHING_STRATEGY_UNSPECIFIED
      EXACT_LOCATION
      INTERSECTING_LOCATION],
     :metadataId integer,
     :metadataKey string,
     :metadataValue string,
     :visibility
     [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]},
    :a1Range string,
    :gridRange
    {:sheetId integer,
     :startRowIndex integer,
     :endRowIndex integer,
     :startColumnIndex integer,
     :endColumnIndex integer}},
   :majorDimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
   :values [[any]]}],
 :includeValuesInResponse boolean,
 :responseValueRenderOption
 [FORMATTED_VALUE UNFORMATTED_VALUE FORMULA],
 :responseDateTimeRenderOption [SERIAL_NUMBER FORMATTED_STRING]}"
  [spreadsheetId BatchUpdateValuesByDataFilterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values:batchUpdateByDataFilter",
     :uri-template-args {:spreadsheetId spreadsheetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body BatchUpdateValuesByDataFilterRequest}))

(defn spreadsheets-values-batchClear
  "Clears one or more ranges of values from a spreadsheet. The caller must specify the spreadsheet ID and one or more ranges. Only values are cleared -- all other properties of the cell (such as formatting and data validation) are kept.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/batchClear

spreadsheetId <string> The ID of the spreadsheet to update.
BatchClearValuesRequest:
{:ranges [string]}"
  [spreadsheetId BatchClearValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values:batchClear",
     :uri-template-args {:spreadsheetId spreadsheetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body BatchClearValuesRequest}))

(defn spreadsheets-values-clear
  "Clears values from a spreadsheet. The caller must specify the spreadsheet ID and range. Only values are cleared -- all other properties of the cell (such as formatting, data validation, etc..) are kept.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/values/clear

spreadsheetId <string> The ID of the spreadsheet to update.
range <string> The [A1 notation or R1C1 notation](/sheets/api/guides/concepts#cell) of the values to clear.
ClearValuesRequest:
object"
  [spreadsheetId range ClearValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values/{range}:clear",
     :uri-template-args {:spreadsheetId spreadsheetId, :range range},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body ClearValuesRequest}))

(defn spreadsheets-developerMetadata-get
  "Returns the developer metadata with the specified ID. The caller must specify the spreadsheet ID and the developer metadata's unique metadataId.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/developerMetadata/get

spreadsheetId <string> The ID of the spreadsheet to retrieve metadata from.
metadataId <integer> The ID of the developer metadata to retrieve."
  [spreadsheetId metadataId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/developerMetadata/{metadataId}",
     :uri-template-args
     {:spreadsheetId spreadsheetId, :metadataId metadataId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"]}))

(defn spreadsheets-developerMetadata-search
  "Returns all developer metadata matching the specified DataFilter. If the provided DataFilter represents a DeveloperMetadataLookup object, this will return all DeveloperMetadata entries selected by it. If the DataFilter represents a location in a spreadsheet, this will return all developer metadata associated with locations intersecting that region.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/developerMetadata/search

spreadsheetId <string> The ID of the spreadsheet to retrieve metadata from.
SearchDeveloperMetadataRequest:
{:dataFilters
 [{:developerMetadataLookup
   {:locationType
    [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
     ROW
     COLUMN
     SHEET
     SPREADSHEET],
    :metadataLocation
    {:locationType
     [DEVELOPER_METADATA_LOCATION_TYPE_UNSPECIFIED
      ROW
      COLUMN
      SHEET
      SPREADSHEET],
     :spreadsheet boolean,
     :sheetId integer,
     :dimensionRange
     {:sheetId integer,
      :dimension [DIMENSION_UNSPECIFIED ROWS COLUMNS],
      :startIndex integer,
      :endIndex integer}},
    :locationMatchingStrategy
    [DEVELOPER_METADATA_LOCATION_MATCHING_STRATEGY_UNSPECIFIED
     EXACT_LOCATION
     INTERSECTING_LOCATION],
    :metadataId integer,
    :metadataKey string,
    :metadataValue string,
    :visibility
    [DEVELOPER_METADATA_VISIBILITY_UNSPECIFIED DOCUMENT PROJECT]},
   :a1Range string,
   :gridRange
   {:sheetId integer,
    :startRowIndex integer,
    :endRowIndex integer,
    :startColumnIndex integer,
    :endColumnIndex integer}}]}"
  [spreadsheetId SearchDeveloperMetadataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/developerMetadata:search",
     :uri-template-args {:spreadsheetId spreadsheetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body SearchDeveloperMetadataRequest}))

(defn spreadsheets-sheets-copyTo
  "Copies a single sheet from a spreadsheet to another spreadsheet. Returns the properties of the newly created sheet.
https://developers.google.com/sheets/reference/rest/v4/spreadsheets/sheets/copyTo

spreadsheetId <string> The ID of the spreadsheet containing the sheet to copy.
sheetId <integer> The ID of the sheet to copy.
CopySheetToAnotherSpreadsheetRequest:
{:destinationSpreadsheetId string}"
  [spreadsheetId sheetId CopySheetToAnotherSpreadsheetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/sheets/{sheetId}:copyTo",
     :uri-template-args
     {:spreadsheetId spreadsheetId, :sheetId sheetId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"],
     :body CopySheetToAnotherSpreadsheetRequest}))
